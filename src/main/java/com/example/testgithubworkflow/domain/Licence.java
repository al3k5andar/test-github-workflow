package com.example.testgithubworkflow.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Licence {

    private String name;
    private String category;
}
