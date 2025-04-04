package com.imdb.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class Person {
    @Id
    @Column(name = "nconst", columnDefinition = "VARCHAR(15)")
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

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Principal> principals;
}
