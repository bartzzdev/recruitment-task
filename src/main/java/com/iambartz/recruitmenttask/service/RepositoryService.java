package com.iambartz.recruitmenttask.service;

import com.iambartz.recruitmenttask.client.GithubClient;
import com.iambartz.recruitmenttask.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
public final class RepositoryService {
    private final GithubClient githubClient;

    public AggregatedRepositoriesDto fetchNotForkRepositoriesForUsername(String username) {
        log.info("Fetching github repositories for username: {}", username);
        var repos = githubClient.getReposForUsername(username)
                .stream()
                .filter(Predicate.not(GithubRepositoryDto::fork))
                .map(repository -> GithubAdapter.toUserRepositoryDto(repository, fetchBranchesByGithubRepository(repository)))
                .toList();
        return new AggregatedRepositoriesDto(repos);
    }

    private List<GithubBranchDto> fetchBranchesByGithubRepository(GithubRepositoryDto dto) {
        var username = dto.owner().login();
        var repository = dto.name();
        log.info("Fetching branches for username: {}, repository: {}", username, repository);
        return githubClient.getBranchesForRepo(username, repository);
    }
}
