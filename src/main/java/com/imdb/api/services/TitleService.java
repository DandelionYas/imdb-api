package com.imdb.api.services;

import com.imdb.api.dtos.TitleDto;
import com.imdb.api.mappers.TitleMapper;
import com.imdb.api.models.Title;
import com.imdb.api.repositories.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
