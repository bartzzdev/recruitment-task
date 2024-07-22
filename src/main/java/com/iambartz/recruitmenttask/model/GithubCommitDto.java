package com.iambartz.recruitmenttask.model;

import lombok.Builder;

@Builder
public record GithubCommitDto(
        String sha
) {
}
