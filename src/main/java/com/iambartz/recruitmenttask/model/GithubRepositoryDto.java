package com.iambartz.recruitmenttask.model;

import lombok.Builder;

@Builder
public record GithubRepositoryDto(
        String name,
        GithubOwnerDto owner,
        boolean fork
) {
}

