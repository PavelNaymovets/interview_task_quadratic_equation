package com.interview.task.quadraticEquation.controller.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquationResponse {
    @JsonProperty
    private double x1;
    @JsonProperty
    private double x2;
}
