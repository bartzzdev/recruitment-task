package com.iambartz.recruitmenttask.service;

import com.iambartz.recruitmenttask.model.GithubBranchDto;
import com.iambartz.recruitmenttask.model.GithubRepositoryDto;
import com.iambartz.recruitmenttask.model.RepositoryBranchDto;
import com.iambartz.recruitmenttask.model.UserRepositoryDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
class GithubAdapter {

    UserRepositoryDto toUserRepositoryDto(GithubRepositoryDto dto, List<GithubBranchDto> githubBranches) {
        var branches = githubBranches.stream()
                .map(GithubAdapter::toRepositoryBranchDto)
                .toList();
        return UserRepositoryDto.builder()
                .repositoryName(dto.name())
                .ownerLogin(dto.owner().login())
                .branches(branches)
                .build();
    }

    RepositoryBranchDto toRepositoryBranchDto(GithubBranchDto dto) {
        return RepositoryBranchDto.builder()
                .name(dto.name())
                .lastCommitSha(dto.commit().sha())
                .build();
    }
}
