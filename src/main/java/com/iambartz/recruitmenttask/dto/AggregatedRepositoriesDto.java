package com.iambartz.recruitmenttask.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AggregatedRepositoriesDto(
        List<UserRepositoryDto> repositories
) {
}
