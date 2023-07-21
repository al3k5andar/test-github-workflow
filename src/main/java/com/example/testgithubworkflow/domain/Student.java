package com.example.testgithubworkflow.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<Licence> licences;
}
