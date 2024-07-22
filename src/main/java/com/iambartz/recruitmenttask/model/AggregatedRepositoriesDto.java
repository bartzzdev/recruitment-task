package com.iambartz.recruitmenttask.model;

import lombok.Builder;

import java.util.List;

@Builder
public record AggregatedRepositoriesDto(
        List<UserRepositoryDto> repositories
) {
}
