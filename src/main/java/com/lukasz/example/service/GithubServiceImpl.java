package com.lukasz.example.service;

import com.lukasz.example.domain.Branch;
import com.lukasz.example.domain.GithubRepository;
import com.lukasz.example.dto.BranchDto;
import com.lukasz.example.dto.GithubRepositoryDto;
import com.lukasz.example.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubServiceImpl implements GithubService {

    private final WebClient webClient;

    public List<GithubRepositoryDto> listNonForkRepositoriesWithBranches(String username) {
        try {
            List<GithubRepository> repositories = fetchRepositoriesForUser(username)
                    .filter(repo -> !repo.isFork())
                    .collectList()
                    .blockOptional().orElseThrow(() -> new UserNotFoundException(username));

            return repositories.stream()
                    .map(repo -> {
                        var branchInfo = fetchBranchesForRepository(repo.getOwner().getLogin(), repo.getName())
                                .collectList().block()
                                .stream()
                                .map(branch -> new BranchDto(branch.getName(), branch.getCommit().getSha()))
                                .collect(Collectors.toList());

                        return new GithubRepositoryDto(repo.getName(), repo.getOwner().getLogin(), branchInfo);
                    })
                    .collect(Collectors.toList());
        } catch (WebClientResponseException.NotFound e) {
            throw new UserNotFoundException(username);
        }
    }

    private Flux<GithubRepository> fetchRepositoriesForUser(String username) {
        return webClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .bodyToFlux(GithubRepository.class);
    }


    private Flux<Branch> fetchBranchesForRepository(String owner, String repoName) {
        return webClient.get()
                .uri("/repos/{owner}/{repoName}/branches", owner, repoName)
                .retrieve()
                .bodyToFlux(Branch.class);
    }
}
