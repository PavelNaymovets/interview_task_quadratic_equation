package com.interview.task.quadraticEquation.controller;

import com.interview.task.quadraticEquation.controller.rest.EquationRequest;
import com.interview.task.quadraticEquation.controller.rest.EquationResponse;
import com.interview.task.quadraticEquation.domain.Equation;
import com.interview.task.quadraticEquation.repository.EquationRepository;
import com.interview.task.quadraticEquation.service.EquationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/equation/resolve")
@RequiredArgsConstructor
public class EquationController {
    private final EquationServiceImpl equationService;

    @PostMapping
    public EquationResponse resolveQuadraticEquation(@RequestBody EquationRequest request) {
        Equation result = equationService.resolve(request.getA(), request.getB(), request.getC());
        return EquationResponse.builder()
                .x1(result.getX1().doubleValue())
                .x2(result.getX2().doubleValue())
                .build();
    }
}
