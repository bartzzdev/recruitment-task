package com.iambartz.recruitmenttask.service;

import com.iambartz.recruitmenttask.client.GithubClient;
import com.iambartz.recruitmenttask.test.GithubDtoFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class RepositoryServiceTest {
    private static final String USERNAME = "username";

    private final GithubClient githubClient = mock(GithubClient.class);
    private final RepositoryService repositoryService = new RepositoryService(githubClient);

    @Test
    void fetchesNotForkRepositoriesForUsername() {
        // given
        var forkRepository = GithubDtoFactory.buildGithubRepository(true);
        var notForkRepository = GithubDtoFactory.buildGithubRepository(false);

        when(githubClient.getReposForUsername(USERNAME))
                .thenReturn(List.of(forkRepository, notForkRepository));
        when(githubClient.getBranchesForRepo(eq(USERNAME), anyString()))
                .thenReturn(List.of(GithubDtoFactory.buildGithubBranch()));

        // when
        var result = repositoryService.fetchNotForkRepositoriesForUsername(USERNAME);

        // then
        assertNotNull(result);
        assertEquals(1, result.repositories().size());
        verify(githubClient, times(1))
                .getBranchesForRepo(forkRepository.owner().login(), forkRepository.name());
    }
}