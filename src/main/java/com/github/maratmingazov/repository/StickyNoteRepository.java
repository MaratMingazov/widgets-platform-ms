package com.github.maratmingazov.repository;

import com.github.maratmingazov.model.Color;
import com.github.maratmingazov.model.StickyNote;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Log4j2
@Service
@RequiredArgsConstructor
public class StickyNoteRepository {

    private final RestClient miroClient;

    public StickyNote createStickyNote(String boardKey, String text, Integer x, Integer y, Color color) {
        var request = new Request(new Data(text), new Style(color.getColor()), new Position(x,y));
        var response =  miroClient.post()
                .uri("/boards/{boardKey}/sticky_notes", boardKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(Response.class);
        return new StickyNote(
                response.id,
                response.data.content,
                Color.valueOf(response.style.fillColor.toUpperCase()),
                response.position.x,
                response.position.y
        );
    }

    public StickyNote getStickyNote(String boardKey, Long stickyNoteId) {
        var response =  miroClient.get()
                .uri("/boards/{boardKey}/sticky_notes/{stickyNoteId}", boardKey, stickyNoteId)
                .retrieve()
                .body(Response.class);
        return new StickyNote(
                response.id,
                response.data.content,
                Color.valueOf(response.style.fillColor.toUpperCase()),
                response.position.x,
                response.position.y
        );
    }

    public void deleteStickyNote(String boardKey, Long stickyNoteId) {
        miroClient.delete()
                .uri("/boards/{boardKey}/sticky_notes/{stickyNoteId}", boardKey, stickyNoteId)
                .retrieve()
                .toBodilessEntity();
    }

    record Request(Data data, Style style, Position position) {}
    record Data(String content) {}
    record Style(String fillColor) { }
    record Position(Integer x, Integer y) { }
    record Response(Long id, Data data, Style style, Position position) { }
}
