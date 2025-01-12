package com.jmario.alurachallege.forumhub.domain.topics.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum Status {
    @JsonProperty("open")
    OPEN("open","Open"),
    @JsonProperty("close")
    CLOSE("close", "Close");

    // Getter for the associated values
    private final String[] values;

    // Constructor for enum with multiple values
    Status(String... values) {
        this.values = values;
    }

    // Static method to convert a string to a Category
    @JsonCreator
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            for (String alias : status.getValues()) {
                if (alias.equalsIgnoreCase(value)) {
                    return status;
                }
            }
        }
        throw new IllegalArgumentException("Unknown category: " + value);
    }
}

