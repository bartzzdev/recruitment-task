package com.iambartz.recruitmenttask.client;

import com.iambartz.recruitmenttask.model.GithubBranchDto;
import com.iambartz.recruitmenttask.model.GithubRepositoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "githubClient", url = "https://api.github.com", configuration = GithubErrorDecoder.class)
public interface GithubClient {

    @GetMapping("/users/{username}/repos")
    List<GithubRepositoryDto> getReposForUsername(@PathVariable String username);

    @GetMapping("/repos/{username}/{repo}/branches")
    List<GithubBranchDto> getBranchesForRepo(@PathVariable String username, @PathVariable String repo);
}
