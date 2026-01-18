package com.github.maratmingazov.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
@RequiredArgsConstructor
public class WidgetEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "widget-events";

    public void sendWidgetCreated(String boardKey, Long widgetId, String widgetType) {
        var event = new WidgetEvent(EventType.WIDGET_CREATED, boardKey, widgetId, widgetType, Instant.now());
        kafkaTemplate.send(TOPIC, boardKey, event);
        log.info("Widget Created event was sent successfully.");
    }

    public void sendWidgetDeleted(String boardKey, Long widgetId) {
        var event = new WidgetEvent(EventType.WIDGET_DELETED, boardKey, widgetId, null, Instant.now());
        kafkaTemplate.send(TOPIC, boardKey, event);
        log.info("Widget Deleted event was sent successfully.");
    }


    public record WidgetEvent(EventType eventType, String boardKey, Long widgetId, String widgetType, Instant occurredAt) {}

    public enum EventType {WIDGET_CREATED, WIDGET_DELETED}
}
