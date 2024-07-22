package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.client.GithubClient;
import com.iambartz.recruitmenttask.service.RepositoryService;
import com.iambartz.recruitmenttask.test.mock.MockWrappedBean;
import org.mockito.AdditionalAnswers;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@AutoConfiguration
public class TestBeanConfiguration {

    @MockWrappedBean
    @Bean
    public RepositoryService repositoryServiceMock(RepositoryService real) {
        return mock(RepositoryService.class, AdditionalAnswers.delegatesTo(real));
    }

    @MockWrappedBean
    @Bean
    public GithubClient githubClientMock(GithubClient real) {
        return mock(GithubClient.class, AdditionalAnswers.delegatesTo(real));
    }
}
