package com.imdb.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.imdb.api.dtos.BestTitleDto;
import com.imdb.api.dtos.TitleDto;
import com.imdb.api.mappers.TitleMapper;
import com.imdb.api.models.Title;
import com.imdb.api.repositories.TitleRepository;
import com.imdb.api.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TitleService {
    private final TitleRepository titleRepository;

    /**
     * Returns all the titles in which both director and writer are the same person
     * and he/she is still alive
     */
    public Page<TitleDto> findTitlesWithSameAndAliveCrew(Pageable pageable) {
        Page<Title> entityPage = titleRepository.findTitlesWithSameAndAliveCrew(pageable);
        return entityPage.map(TitleMapper.INSTANCE::entityToDto);
    }

    /**
     * Get two actors and return all the titles in which both of them played at
     */
    public Page<TitleDto> findTitlesInWhichTwoActorsPlayedAt(String actor1, String actor2 , Pageable pageable) {
        Page<Title> entityPage = titleRepository.findTitlesInWhichTwoActorsPlayedAt(actor1, actor2, pageable);
        return entityPage.map(TitleMapper.INSTANCE::entityToDto);
    }

    /**
     * Get a genre and return best titles on each year for that genre based on
     * number of votes and rating
     */
    public List<BestTitleDto> findBestTitlesOnEachYearByGenre(String genre) {
        List<Map<String, Object>> result = titleRepository.findBestTitlesOnEachYearByGenre(genre);
        return JsonUtils.convert(result, new TypeReference<List<BestTitleDto>>() {});
    }
}
