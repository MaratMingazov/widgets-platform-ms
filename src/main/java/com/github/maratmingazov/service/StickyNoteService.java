package com.github.maratmingazov.service;

import com.github.maratmingazov.model.Color;
import com.github.maratmingazov.model.StickyNote;

/**
 * Service responsible for managing Sticky Note widgets on a board.
 *
 * This service provides basic CRUD-like operations for Sticky Notes,
 * such as creating, retrieving, and deleting widgets within a specific board.
 *
 * The service abstracts the underlying storage or external API (e.g. Miro API)
 * and exposes a simple domain-oriented interface to the application layer.
 */
public interface StickyNoteService {

    /**
     * Retrieves a Sticky Note by its identifier from the specified board.
     *
     * @param boardKey the unique identifier of the board where the sticky note is located
     * @param stickyNoteId the unique identifier of the sticky note
     * @return the {@link StickyNote} associated with the given board and identifier
     * @throws IllegalArgumentException if the sticky note does not exist or does not belong to the specified board
     */
    StickyNote getStickyNoteById(String boardKey, Long stickyNoteId);

    /**
     * Creates a new Sticky Note on the specified board.
     *
     * @param boardKey the unique identifier of the board where the sticky note will be created
     * @param text the text content of the sticky note
     * @param x the horizontal position (X coordinate) of the sticky note
     * @param y the vertical position (Y coordinate) of the sticky note
     * @param color the visual color of the sticky note
     * @return the created {@link StickyNote} including its generated identifier
     * @throws IllegalArgumentException if input parameters are invalid
     */
    StickyNote createStickyNote(String boardKey, String text, Integer x, Integer y, Color color);

    /**
     * Deletes a Sticky Note by its identifier from the specified board.
     *
     * @param boardKey the unique identifier of the board from which the sticky note will be deleted
     * @param stickyNoteId the unique identifier of the sticky note to delete
     * @throws IllegalArgumentException if the sticky note does not exist or does not belong to the specified board
     */
    void deleteStickyNoteById(String boardKey, Long stickyNoteId);
}
