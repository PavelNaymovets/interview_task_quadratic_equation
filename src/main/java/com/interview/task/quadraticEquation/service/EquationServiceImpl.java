package com.interview.task.quadraticEquation.service;

import com.interview.task.quadraticEquation.domain.Equation;
import com.interview.task.quadraticEquation.entity.EquationEntity;
import com.interview.task.quadraticEquation.exception.NoRootsOfEquationException;
import com.interview.task.quadraticEquation.repository.EquationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
@RequiredArgsConstructor
public class EquationServiceImpl implements EquationService {
    private final EquationRepository equationRepository;

    @Override
    public Equation resolve(double varA, double varB, double varC) {
        BigDecimal a = new BigDecimal(varA);
        BigDecimal b = new BigDecimal(varB);
        BigDecimal c = new BigDecimal(varC);

        BigDecimal discriminant = b.pow(2).subtract(a.multiply(c).multiply(BigDecimal.valueOf(4)));

        if (discriminant.doubleValue() >= 0) {

            BigDecimal sqrt = discriminant.sqrt(MathContext.DECIMAL64);
            BigDecimal a2 = a.multiply(BigDecimal.valueOf(2));

            BigDecimal x1 = b.negate().add(sqrt).divide(a2);
            BigDecimal x2 = b.negate().subtract(sqrt).divide(a2);

            EquationEntity entity = EquationEntity.builder()
                    .a(a)
                    .b(b)
                    .c(c)
                    .x1(x1)
                    .x2(x2)
                    .build();

            entity = equationRepository.save(entity);

            return Equation.builder()
                    .id(entity.getId())
                    .a(entity.getA())
                    .b(entity.getB())
                    .c(entity.getC())
                    .x1(entity.getX1())
                    .x2(entity.getX2())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();

        } else {
            throw new NoRootsOfEquationException("No roots");
        }
    }

}
