package com.app.eventscheduling.service;

import com.app.eventscheduling.model.Event;
import com.app.eventscheduling.model.Participant;

import java.util.HashMap;
import java.util.Map;

public class EventScheduler {
    private Map<String, Event> events;

    // TODO: Implement constructor
    public EventScheduler() {
        this.events = new HashMap<>();
    }

    // TODO: Implement method to schedule an event
    public void scheduleEvent(Event event) {

    }

    // TODO: Implement method to register a participant for an event
    public void registerParticipant(String eventId, Participant participant) {

    }

    // TODO: Implement method to mark attendance for a participant in an event
    public void markAttendance(String eventId, String participantId) {

    }

    // TODO: Implement method to get event details
    public String getEventDetails(String eventId) {
        return null;
    }

    public Map<String, Event> getEvents() {
        return null;
    }
}

