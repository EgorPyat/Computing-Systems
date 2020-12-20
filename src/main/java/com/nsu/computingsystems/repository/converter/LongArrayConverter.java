package com.nsu.computingsystems.repository.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class LongArrayConverter implements AttributeConverter<List<Long>, String> {

    private final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<Long> attribute) {
        return attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(SEPARATOR))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
