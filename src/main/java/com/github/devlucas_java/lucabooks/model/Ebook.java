package com.github.devlucas_java.lucabooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ebook")
public class Ebook {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
