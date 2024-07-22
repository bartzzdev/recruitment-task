package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

@Builder
public record GithubBranchDto(
        String name,
        GithubCommitDto commit
) {
}
