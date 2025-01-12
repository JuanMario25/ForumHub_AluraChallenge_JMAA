package com.jmario.alurachallege.forumhub.domain.courses.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum Category {
    @JsonProperty("programming")
    PROGRAMMING("programming", "coding", "Programming"),
    @JsonProperty("maths")
    MATHS("maths", "mathematics"),
    @JsonProperty("chemistry")
    CHEMISTRY("chemistry", "chem"),
    @JsonProperty("other")
    OTHER("other", "miscellaneous");

    // Getter for the associated values
    private final String[] values;

    // Constructor for enum with multiple values
    Category(String... values) {
        this.values = values;
    }

    // Static method to convert a string to a Category
    @JsonCreator
    public static Category fromString(String value) {
        for (Category category : Category.values()) {
            for (String alias : category.getValues()) {
                if (alias.equalsIgnoreCase(value)) {
                    return category;
                }
            }
        }
        throw new IllegalArgumentException("Unknown category: " + value);
    }
}

