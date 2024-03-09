package com.lukasz.example.controllers;

import com.lukasz.example.dto.GithubRepositoryDto;
import com.lukasz.example.service.GithubServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GithubController {

    private final GithubServiceImpl githubService;

    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<GithubRepositoryDto>> listRepositories(@PathVariable String username) {
        return ResponseEntity.ok(githubService.listNonForkRepositoriesWithBranches(username));
    }
}
