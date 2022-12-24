package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId);
    }

    public void addMeeting(Meeting meeting) {
        // add the meeting to calendar
        if (calendar.size() == 0) {
            calendar.add(meeting);
        }

        ArrayList<Meeting> newCalendar = new ArrayList<>();
        while (calendar.size() > 0 && calendar.get(0).getEndTime().compareTo(meeting.getEndTime()) < 0) {
            newCalendar.add(calendar.get(0));
            calendar.remove(0);
        }

        newCalendar.add(meeting);

        int n = calendar.size();
        for (int i = 0; i < n; i++) {
            newCalendar.add(calendar.get(0));
        }

        calendar = newCalendar;
    }

    public int findMaxMeetings() {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and
        // leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting
        // starting at 10:00 am
        int count = 1;
        LocalTime presentMeetingEndTime = calendar.get(0).getEndTime();

        for (int i = 0; i < calendar.size(); i++) {
            if (presentMeetingEndTime.compareTo(calendar.get(i).getStartTime()) < 0) {
                count++;
                presentMeetingEndTime = calendar.get(i).getEndTime();
            }
        }
        return count;
    }
}
