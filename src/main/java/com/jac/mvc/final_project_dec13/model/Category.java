package com.jac.mvc.final_project_dec13.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-07
 * Project: team1
 */
@Entity
@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;


    @Column(name = "age_range", nullable = false)
    private String ageRange;

}

