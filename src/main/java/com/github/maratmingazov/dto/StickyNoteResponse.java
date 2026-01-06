package com.github.maratmingazov.dto;

import com.github.maratmingazov.model.Color;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Value
@AllArgsConstructor
@Schema(description = "Create StickyNote Response")
public class StickyNoteResponse {

    @Schema(description = "Widget id")
    String id;

    @Schema(description = "Widget content")
    String text;

    @Schema(description = "Widget color")
    Color color;

    @Schema(description = "Widget position")
    Integer x;

    @Schema(description = "Widget position")
    Integer y;
}
