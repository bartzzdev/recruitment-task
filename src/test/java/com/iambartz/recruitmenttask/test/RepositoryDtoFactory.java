package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.model.AggregatedRepositoriesDto;
import com.iambartz.recruitmenttask.model.RepositoryBranchDto;
import com.iambartz.recruitmenttask.model.UserRepositoryDto;

import java.util.List;

public final class RepositoryDtoFactory {
    private RepositoryDtoFactory() {}

    public static AggregatedRepositoriesDto buildAggregatedRepositories() {
        return AggregatedRepositoriesDto.builder().build();
    }

    public static AggregatedRepositoriesDto buildAggregatedRepositories(UserRepositoryDto... userRepositoryDtos) {
        return AggregatedRepositoriesDto.builder()
                .repositories(List.of(userRepositoryDtos))
                .build();
    }

    public static UserRepositoryDto buildUserRepository() {
        return UserRepositoryDto.builder()
                .repositoryName("repositoryName")
                .ownerLogin("ownerLogin")
                .branches(List.of(buildRepositoryBranch()))
                .build();
    }

    public static RepositoryBranchDto buildRepositoryBranch() {
        return RepositoryBranchDto.builder()
                .name("name")
                .lastCommitSha("sha")
                .build();
    }
}
