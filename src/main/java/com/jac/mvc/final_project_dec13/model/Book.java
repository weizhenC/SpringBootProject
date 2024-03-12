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
@Table(name="books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long id;

    @Column(name = "ISBN", nullable = false)
    private String ISBN;

    @Column(name = "book_name")
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}

