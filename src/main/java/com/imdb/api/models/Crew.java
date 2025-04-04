package com.imdb.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "crew")
public class Crew {

    @Id
    @Column(name = "tconst", columnDefinition = "VARCHAR(15)")
    private String titleId;

    @Column(columnDefinition = "VARCHAR(6000)")
    private String directors;

    @Column(columnDefinition = "VARCHAR(50000)")
    private String writers;
}
