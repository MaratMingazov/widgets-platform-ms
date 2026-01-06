package com.github.maratmingazov.controller;

import com.github.maratmingazov.dto.StickyNoteRequest;
import com.github.maratmingazov.dto.StickyNoteResponse;
import com.github.maratmingazov.service.StickyNoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stickyNote")
public class WidgetsController {

    private final StickyNoteService stickyNoteService;

    @GetMapping
    @Operation(summary = "Get StickyNote")
    public ResponseEntity<StickyNoteResponse> getStickyNote(String boardKey, Long widgetId) {
        var stickyNote = stickyNoteService.getStickyNoteById(boardKey, widgetId);
        StickyNoteResponse response = new StickyNoteResponse(stickyNote.id().toString(), stickyNote.text(), stickyNote.color(), stickyNote.x(), stickyNote.y());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Create new StickyNote")
    public ResponseEntity<StickyNoteResponse> createStickyNote(@RequestBody StickyNoteRequest request) {
        var stickyNote = stickyNoteService.createStickyNote(request.getBoardKey(), request.getText(), request.getX(), request.getY(), request.getColor());
        var response = new StickyNoteResponse(stickyNote.id().toString(), stickyNote.text(), stickyNote.color(), stickyNote.x(), stickyNote.y());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Operation(summary = "Delete StickyNote")
    public ResponseEntity<Void> deleteStickyNote(String boardKey, Long widgetId) {
        stickyNoteService.deleteStickyNoteById(boardKey, widgetId);
        return ResponseEntity.ok().build();
    }
}
