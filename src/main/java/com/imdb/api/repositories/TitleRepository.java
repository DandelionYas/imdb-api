package com.imdb.api.repositories;

import com.imdb.api.models.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @NativeQuery(
            value =
                    "SELECT title.* FROM title " +
                            "INNER JOIN principal ON title.tconst = principal.tconst " +
                            "INNER JOIN person ON principal.nconst = person.nconst " +
                            "AND (person.primaryName = :actor1 OR person.primaryName = :actor2)",
            countQuery =
                    "SELECT COUNT(title.*) FROM title " +
                            "INNER JOIN principal ON title.tconst = principal.tconst " +
                            "INNER JOIN person ON principal.nconst = person.nconst " +
                            "AND (person.primaryName = :actor1 OR person.primaryName = :actor2)")
    Page<Title> findTitlesInWhichTwoActorsPlayedAt(String actor1, String actor2, Pageable pageable);

    @NativeQuery(
            value =
                    "WITH bestEachYear  AS ( " +
                            "    SELECT t1.endYear, MAX(r1.averageRating) AS maxRating " +
                            "    FROM title t1 INNER JOIN rating r1 " +
                            "        ON t1.tconst = r1.tconst " +
                            "               AND r1.numVotes > (SELECT AVG(numVotes) FROM title t2 " +
                            "                   INNER JOIN rating r2 ON t2.tconst = r2.tconst AND t1.endYear = t2.endYear) " +
                            "    WHERE t1.genres LIKE '%' + :genre + '%' " +
                            "    GROUP BY t1.endYear) " +
                            "SELECT t.endYear AS year, t.tconst AS titleId, t.primaryTitle, " +
                            "       t.originalTitle, r.averageRating, r.numVotes " +
                            "    FROM bestEachYear b INNER JOIN title t ON b.endYear = t.endYear " +
                            "        INNER JOIN rating r ON t.tconst = r.tconst AND b.maxRating = r.averageRating")
    List<Map<String,Object>> findBestTitlesOnEachYearByGenre(String genre);
}
