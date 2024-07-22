package com.iambartz.recruitmenttask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iambartz.recruitmenttask.exception.UsernameNotFoundException;
import com.iambartz.recruitmenttask.model.AggregatedRepositoriesDto;
import com.iambartz.recruitmenttask.service.RepositoryService;
import com.iambartz.recruitmenttask.test.AbstractTest;
import com.iambartz.recruitmenttask.test.RepositoryDtoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RepositoryControllerIntTest extends AbstractTest {
    private static final String REPOSITORY_API_URL = "/api/v1/repositories";
    private static final String USER_REPOS_URL = REPOSITORY_API_URL + "/{username}";
    private static final String USERNAME = "username";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void fetchesUserNotForkRepositoriesFromGithub() throws Exception {
        // given
        var aggregatedRepositories = RepositoryDtoFactory.buildAggregatedRepositories();
        doReturn(aggregatedRepositories)
                .when(repositoryService).fetchNotForkRepositoriesForUsername(USERNAME);

        // when
        var response = mockMvc.perform(get(USER_REPOS_URL, USERNAME))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        var result = objectMapper.readValue(response.getContentAsString(), AggregatedRepositoriesDto.class);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(aggregatedRepositories, result);
    }

    @Test
    void returnsNotFoundIfUsernameNotFoundOnGithub() throws Exception {
        // given
        doThrow(UsernameNotFoundException.class).when(repositoryService).fetchNotForkRepositoriesForUsername(USERNAME);

        // when then
        mockMvc.perform(get(USER_REPOS_URL, USERNAME))
                .andExpect(status().isNotFound());
    }
}