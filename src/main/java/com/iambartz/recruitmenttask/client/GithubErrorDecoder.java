package com.iambartz.recruitmenttask.client;

import com.iambartz.recruitmenttask.exception.UsernameNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class GithubErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new UsernameNotFoundException();
        }
        return errorDecoder.decode(methodKey, response);
    }
}
