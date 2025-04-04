package com.imdb.api.repositories;

import com.imdb.api.models.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, String> {

    @NativeQuery(
            value =
                    "SELECT title.* FROM title " +
                            "INNER JOIN crew ON title.tconst = crew.tconst AND crew.directors = crew.writers " +
                            "INNER JOIN person ON crew.directors like '%' + person.primaryName + '%' AND person.deathYear like '%\\N%' ",
            countQuery =
                    "SELECT COUNT(title.*) FROM title " +
                            "INNER JOIN crew ON title.tconst = crew.tconst AND crew.directors = crew.writers " +
                            "INNER JOIN person ON crew.directors like '%' + person.primaryName + '%' AND person.deathYear like '%\\N%' ")
    Page<Title> findTitlesWithSameAndAliveCrew(Pageable pageable);
}
