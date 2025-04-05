package com.imdb.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static <T> T convert(final Object fromValue, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(fromValue, typeReference);
    }
}
