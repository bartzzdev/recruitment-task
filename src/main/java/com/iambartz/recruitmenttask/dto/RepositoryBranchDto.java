package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

@Builder
public record RepositoryBranchDto(
        String name,
        String lastCommitSha
) {
}
