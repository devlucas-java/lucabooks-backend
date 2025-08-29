package com.github.devlucas_java.lucabooks.model;

import com.github.devlucas_java.lucabooks.model.enums.Nacionality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artist")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "nacionality", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Nacionality nacionality;

    @Column(name = "description", length = 1000)
    private String description;

    @Lob
    @Column(name = "image_byte", columnDefinition = "BLOB")
    private byte[] imageByte;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ebook> ebooks;
}
