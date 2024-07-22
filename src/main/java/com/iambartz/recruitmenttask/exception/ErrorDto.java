package com.iambartz.recruitmenttask.exception;

import lombok.Builder;

@Builder
record ErrorDto(
        int status,
        String message
) {
}
