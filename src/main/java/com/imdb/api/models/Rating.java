package com.imdb.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst", columnDefinition = "VARCHAR(15)")
    private Title title;

    @Column(columnDefinition = "FLOAT")
    private Float averageRating;

    @Column(columnDefinition = "INT")
    private Integer numVotes;
}
