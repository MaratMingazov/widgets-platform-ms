package com.github.maratmingazov.service;

import com.github.maratmingazov.model.Color;
import com.github.maratmingazov.model.StickyNote;
import com.github.maratmingazov.repository.StickyNoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class StickyNoteServiceImpl implements StickyNoteService{

    private final StickyNoteRepository stickyNoteRepository;

    @Value("${DEFAULT_COLOR}")
    private Color defaultColor;

    @Override
    public StickyNote getStickyNoteById(String boardKey, Long stickyNoteId) {
        val stickyNote = stickyNoteRepository.getStickyNote(boardKey, stickyNoteId);
        log.info("StickyNote was received with id: {} ", stickyNote.id());
        return stickyNote;
    }

    @Override
    public StickyNote createStickyNote(String boardKey, String text, Integer x, Integer y, Color color) {
        var stickyNote = stickyNoteRepository.createStickyNote(boardKey, text, x, y, (color != null) ? color : defaultColor);
        log.info("StickyNote was created with id: {} ", stickyNote.id());
        return stickyNote;
    }

    @Override
    public void deleteStickyNoteById(String boardKey, Long stickyNoteId) {
        stickyNoteRepository.deleteStickyNote(boardKey, stickyNoteId);
        log.info("StickyNote was deleted with id: {} ", stickyNoteId);
    }
}
