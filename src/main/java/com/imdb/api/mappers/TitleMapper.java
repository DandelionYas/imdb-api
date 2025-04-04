package com.imdb.api.mappers;

import com.imdb.api.dtos.TitleDto;
import com.imdb.api.models.Title;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TitleMapper {
    TitleMapper INSTANCE = Mappers.getMapper(TitleMapper.class);

    Title dtoToEntity(TitleDto titleDto);

    TitleDto entityToDto(Title title);
}
