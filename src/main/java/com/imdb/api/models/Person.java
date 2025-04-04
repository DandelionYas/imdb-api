package com.imdb.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "nconst",columnDefinition = "VARCHAR(15)")
    private String id;

    @Column(columnDefinition = "VARCHAR(200)")
    private String primaryName;

    @Column(columnDefinition = "VARCHAR(20)")
    private String birthYear;

    @Column(columnDefinition = "VARCHAR(20)")
    private String deathYear;

    @Column(columnDefinition = "VARCHAR(500)")
    private String primaryProfession;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String knownForTitles;
}
