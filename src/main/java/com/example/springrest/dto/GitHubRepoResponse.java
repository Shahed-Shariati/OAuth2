package com.example.springrest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubRepoResponse {

    @JsonProperty("name")
    private String name;
}
