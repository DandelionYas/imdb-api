package com.imdb.api.controllers;

import com.imdb.api.dtos.TitleDto;
import com.imdb.api.services.TitleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get Title with same alive crew",
            description = "Returns all the titles in which both director and " +
                    "writer are the same person and he/she is still alive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Title records found and returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("/same-alive-crew")
    public Page<TitleDto> findTitlesWithSameAndAliveCrew(Pageable pageable) {
        return titleService.findTitlesWithSameAndAliveCrew(pageable);
    }
}
