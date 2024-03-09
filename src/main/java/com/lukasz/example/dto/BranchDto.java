package com.lukasz.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString(of = {"name", "lastCommitSha"})
public class BranchDto {

    private String name;
    private String lastCommitSha;

}
