package com.imdb.api.controllers;

import com.imdb.api.models.Title;
import com.imdb.api.services.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/titles")
public class TitleController {
    private final TitleService titleService;

    @GetMapping("/same-alive-crew")
    public Page<Title> findTitlesWithSameAndAliveCrew(Pageable pageable) {
        return titleService.findTitlesWithSameAndAliveCrew(pageable);
    }
}
