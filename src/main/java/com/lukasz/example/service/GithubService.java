package com.lukasz.example.service;

import com.lukasz.example.dto.GithubRepositoryDto;

import java.util.List;

public interface GithubService {

    List<GithubRepositoryDto> listNonForkRepositoriesWithBranches(String username);

}
