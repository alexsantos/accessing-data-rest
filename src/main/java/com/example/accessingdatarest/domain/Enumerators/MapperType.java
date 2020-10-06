package com.example.accessingdatarest.domain.Enumerators;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MapperType {
    TEXT("text"),
    FIELD("field"),
    TRANSCODING("transcoding");

    private final String value;

    MapperType(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String getValue() {
        return value;
    }
}
