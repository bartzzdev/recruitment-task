package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

@Builder
public record GithubOwnerDto(
        String login
) {
}
