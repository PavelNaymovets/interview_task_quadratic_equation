package com.interview.task.quadraticEquation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equation {
    private Long id;
    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;
    private BigDecimal x1;
    private BigDecimal x2;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
