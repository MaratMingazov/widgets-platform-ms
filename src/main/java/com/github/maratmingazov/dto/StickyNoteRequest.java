package com.github.maratmingazov.dto;

import com.github.maratmingazov.model.Color;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Schema(description = "Create Sticky Note request")
public class StickyNoteRequest {

    @Schema(description = "Board Key")
    String boardKey;

    @Schema(description = "Widget content")
    String text;

    @Schema(description = "Widget color")
    Color color;

    @Schema(description = "Widget position")
    Integer x;

    @Schema(description = "Widget position")
    Integer y;
}
