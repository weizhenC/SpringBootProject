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
@Table(name="authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "author_nationality", nullable = false)
    private String nationality;

}

