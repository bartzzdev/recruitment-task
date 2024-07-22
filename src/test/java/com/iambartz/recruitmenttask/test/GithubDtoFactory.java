package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.model.GithubBranchDto;
import com.iambartz.recruitmenttask.model.GithubCommitDto;
import com.iambartz.recruitmenttask.model.GithubOwnerDto;
import com.iambartz.recruitmenttask.model.GithubRepositoryDto;

public final class GithubDtoFactory {
    private GithubDtoFactory() {}

    public static GithubBranchDto buildGithubBranch() {
        return GithubBranchDto.builder()
                .name("Branch")
                .commit(GithubCommitDto.builder()
                        .sha("SHA")
                        .build())
                .build();
    }

    public static GithubRepositoryDto buildGithubRepository(boolean fork) {
        return GithubRepositoryDto.builder()
                .name("Repository")
                .owner(GithubOwnerDto.builder()
                        .login("Login")
                        .build())
                .fork(fork)
                .build();
    }
}
