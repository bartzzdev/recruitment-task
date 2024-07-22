package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UserRepositoryDto(
        String repositoryName,
        String ownerLogin,
        List<RepositoryBranchDto> branches
) {
}
