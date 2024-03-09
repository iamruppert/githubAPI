package com.lukasz.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString(of = {"name", "owner", "branchList"})
public class GithubRepositoryDto {

    private String name;
    private String owner;
    private List<BranchDto> branchList;

}
