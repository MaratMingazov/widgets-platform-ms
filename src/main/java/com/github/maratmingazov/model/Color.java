package com.github.maratmingazov.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Widget color")
public enum Color {
    RED("red"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue");

    private final String color;

    Color(String color) {
        this.color = color.toLowerCase();
    }

}
