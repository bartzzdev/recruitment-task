package com.iambartz.recruitmenttask.controller;

import com.iambartz.recruitmenttask.ApiConstants;
import com.iambartz.recruitmenttask.model.AggregatedRepositoriesDto;
import com.iambartz.recruitmenttask.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.BASE_API_URL + "/repositories")
@RequiredArgsConstructor
public class RepositoryController {
    private final RepositoryService githubService;

    @GetMapping("/{username}")
    public AggregatedRepositoriesDto getUserNotForkRepositories(@PathVariable String username) {
        return githubService.fetchNotForkRepositoriesForUsername(username);
    }
}
