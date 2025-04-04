package com.imdb.api.dtos;

import com.imdb.api.models.Rating;

public record TitleDto(String id,
                       String titleType,
                       String primaryTitle,
                       String originalTitle,
                       String isAdult,
                       String startYear,
                       String endYear,
                       String runtimeMinutes,
                       String genres,
                       Rating rating) {
}