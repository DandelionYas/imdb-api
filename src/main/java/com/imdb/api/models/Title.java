package com.imdb.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class Title {
    @Id
    @Column(name = "tconst", columnDefinition = "VARCHAR(15)")
    private String id;

    @Column(columnDefinition = "VARCHAR(25)")
    private String titleType;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String primaryTitle;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String originalTitle;

    @Column(columnDefinition = "VARCHAR(128)")
    private String isAdult;

    @Column(columnDefinition = "VARCHAR(255)")
    private String startYear;

    @Column(columnDefinition = "VARCHAR(255)")
    private String endYear;

    @Column(columnDefinition = "VARCHAR(128)")
    private String runtimeMinutes;

    @Column(columnDefinition = "VARCHAR(500)")
    private String genres;

    @OneToOne(mappedBy = "title")
    private Rating rating;

    @OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Principal> principals;
}
