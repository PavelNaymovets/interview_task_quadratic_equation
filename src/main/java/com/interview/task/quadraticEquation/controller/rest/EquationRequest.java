package com.interview.task.quadraticEquation.controller.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquationRequest {
    @JsonProperty
    private double a;
    @JsonProperty
    private double b;
    @JsonProperty
    private double c;
}
