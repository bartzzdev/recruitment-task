package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

@Builder
public record GithubCommitDto(
        String sha
) {
}
