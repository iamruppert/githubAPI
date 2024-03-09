package com.lukasz.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"sha"})
@Data
public class Commit {

    private String sha;

}
