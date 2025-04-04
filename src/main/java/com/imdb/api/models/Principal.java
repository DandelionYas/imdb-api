package com.imdb.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Principal {
    @Id
    @Column(name = "ordering", columnDefinition = "INT")
    private Integer id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String category;

    @Column(columnDefinition = "VARCHAR(300)")
    private String job;

    @Column(columnDefinition = "VARCHAR(1500)")
    private String characters;

    @ManyToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", columnDefinition = "VARCHAR(15)")
    private Title title;

    @ManyToOne
    @JoinColumn(name = "nconst", referencedColumnName = "nconst", columnDefinition = "VARCHAR(15)")
    private Person person;
}
