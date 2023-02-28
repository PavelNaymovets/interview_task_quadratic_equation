package com.interview.task.quadraticEquation.service;

import com.interview.task.quadraticEquation.domain.Equation;

public interface EquationService {
    public Equation resolve(double a, double b, double c);
}
