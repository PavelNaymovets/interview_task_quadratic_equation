package com.interview.task.quadraticEquation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "equation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "a")
    private BigDecimal a;

    @Column(name = "b")
    private BigDecimal b;

    @Column(name = "c")
    private BigDecimal c;

    @Column(name = "x1")
    private BigDecimal x1;

    @Column(name = "x2")
    private BigDecimal x2;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
