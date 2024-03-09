import com.app.eventscheduling.model.Event;
import com.app.eventscheduling.model.Participant;
import com.app.eventscheduling.service.EventScheduler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventSchedulerTest {

    @Test
    void scheduleEvent_shouldAddEventToScheduler() {
        EventScheduler eventScheduler = new EventScheduler();
        Event event = new Event("E001", "Sample Event", "2024-03-15", "09:00 AM", "City Park");

        eventScheduler.scheduleEvent(event);

        assertTrue(eventScheduler.getEvents().containsKey("E001"));
        assertEquals(event, eventScheduler.getEvents().get("E001"));
    }

    @Test
    void registerParticipant_shouldAddParticipantToEvent() {
        EventScheduler eventScheduler = new EventScheduler();
        Event event = new Event("E001", "Sample Event", "2024-03-15", "09:00 AM", "City Park");
        eventScheduler.scheduleEvent(event);
        Participant participant = new Participant("P001", "John Doe", "john@example.com");

        eventScheduler.registerParticipant("E001", participant);

        assertTrue(event.getParticipants().contains(participant));
    }

    @Test
    void markAttendance_shouldUpdateAttendanceStatus() {
        EventScheduler eventScheduler = new EventScheduler();
        Event event = new Event("E001", "Sample Event", "2024-03-15", "09:00 AM", "City Park");
        eventScheduler.scheduleEvent(event);
        Participant participant = new Participant("P001", "John Doe", "john@example.com");
        eventScheduler.registerParticipant("E001", participant);

        eventScheduler.markAttendance("E001", "P001");

        assertTrue(participant.isAttended());
    }

    @Test
    void getEventDetails_shouldReturnEventDetails() {
        EventScheduler eventScheduler = new EventScheduler();
        Event event = new Event("E001", "Sample Event", "2024-03-15", "09:00 AM", "City Park");
        eventScheduler.scheduleEvent(event);
        Participant participant = new Participant("P001", "John Doe", "john@example.com");
        eventScheduler.registerParticipant("E001", participant);

        String eventDetails = eventScheduler.getEventDetails("E001");

        assertTrue(eventDetails.contains("Sample Event"));
        assertTrue(eventDetails.contains("John Doe"));
    }
}

