package com.app.eventscheduling.model;

import java.util.Collection;
import java.util.List;

public class Event {
    private String eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private List<Participant> participants;

    public String getEventId() {
        return eventId;
    }

    public List<Participant> getParticipants() {
        return null;
    }


    // TODO: Implement constructor

    // TODO: Implement getters and setters

    // TODO: Implement method to add a participant to the event

    // TODO: Implement method to mark attendance for a participant
}

