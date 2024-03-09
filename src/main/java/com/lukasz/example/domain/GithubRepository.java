package com.lukasz.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(of = {"name", "fork", "owner", "branchList"})
public class GithubRepository {

    private String name;
    private boolean fork;
    private Owner owner;
    private List<Branch> branchList;

}
