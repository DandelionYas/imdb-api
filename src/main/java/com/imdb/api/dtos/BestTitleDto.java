package com.imdb.api.dtos;

public record BestTitleDto(String year,
                           String titleId,
                           String primaryTitle,
                           String originalTitle,
                           String averageRating,
                           String numVotes) {
}
