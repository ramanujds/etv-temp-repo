Case Study: Event Scheduling and Attendance Tracking System

Background:
A community organization is hosting various events throughout the year and wants to implement an efficient system for scheduling events, managing attendance, and tracking participant information. Java collections, including Maps and Lists, will be used to handle the data.

Objective:
Develop an Event Scheduling and Attendance Tracking System that leverages Java collections to manage events, participants, and attendance records. The system should support event scheduling, participant registration, marking attendance, and generating reports.

Requirements:

1. **Event Information:**
    - Each event has attributes such as name, date, time, location, and a unique identifier (Event ID).
    - Implement a class to represent an Event with the necessary attributes and methods.

2. **Event Scheduling:**
    - Utilize a Map to store scheduled events, where the Event ID serves as the key.
    - The value associated with each Event ID should include event details and a list of participants.

3. **Participant Information:**
    - Implement a class to represent a Participant with attributes such as name, contact information, and a unique identifier (Participant ID).

4. **Participant Registration:**
    - Allow participants to register for events by providing their details.
    - Maintain a list of registered participants for each event.

5. **Marking Attendance:**
    - Implement functionality to mark the attendance of participants for a specific event.
    - Track the attendance status of each participant.

6. **Viewing Event Details:**
    - Develop methods to display detailed information about a specific event, including its scheduled date, time, location, and the list of registered participants.

7. **Attendance Reports:**
    - Generate reports showing the attendance status of participants for each event.
    - Provide options to filter reports based on event date, location, or participant details.

8. **Error Handling:**
    - Handle cases where a participant tries to register for an event that is already at full capacity or mark attendance for an event they are not registered for.

Sample Usage Scenario:
The community organization wants to schedule a charity run event with the following details:
- Event Name: Charity Run
- Date: March 15, 2024
- Time: 9:00 AM
- Location: City Park

Participants register for the event, and the system tracks their attendance on the event day.
