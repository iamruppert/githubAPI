package com.lukasz.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"name", "commit"})
@Data
public class Branch {

    private String name;
    private Commit commit;

}
