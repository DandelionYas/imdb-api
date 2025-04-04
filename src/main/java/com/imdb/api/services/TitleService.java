package com.imdb.api.services;

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

    public Page<Title> findTitlesWithSameAndAliveCrew(Pageable pageable) {
        return titleRepository.findTitlesWithSameAndAliveCrew(pageable);
    }
}
