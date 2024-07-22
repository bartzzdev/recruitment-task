package com.iambartz.recruitmenttask.model;

import lombok.Builder;

@Builder
public record RepositoryBranchDto(
        String name,
        String lastCommitSha
) {
}
