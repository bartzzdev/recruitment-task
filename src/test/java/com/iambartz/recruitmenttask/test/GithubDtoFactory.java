package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.dto.GithubBranchDto;
import com.iambartz.recruitmenttask.dto.GithubCommitDto;
import com.iambartz.recruitmenttask.dto.GithubOwnerDto;
import com.iambartz.recruitmenttask.dto.GithubRepositoryDto;

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
