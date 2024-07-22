package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

@Builder
public record GithubRepositoryDto(
        String name,
        GithubOwnerDto owner,
        boolean fork
) {
}

