package com.iambartz.recruitmenttask.model;

import lombok.Builder;

@Builder
public record GithubBranchDto(
        String name,
        GithubCommitDto commit
) {
}
