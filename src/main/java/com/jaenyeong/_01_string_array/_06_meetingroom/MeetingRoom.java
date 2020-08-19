package com.jaenyeong._01_string_array._06_meetingroom;

import java.util.*;

public class MeetingRoom {
    /*
    [Question]
    Given an array of meeting time intervals consisting of start and end times [[s1, e1], [s2, e2], ...] (si > ei),
    find the minimum number of conference rooms required.

    [Input]
    > [[0, 30], [5, 10], [15, 20]]
    [Output]
    > 2

    [Input]
    > [[7, 10], [2, 4]]
    [Output]
    > 1

     */

    public static void main(String[] args) {
//        Meeting meeting1 = new Meeting(5, 10);
//        Meeting meeting2 = new Meeting(15, 20);
//        Meeting meeting3 = new Meeting(0, 30);
//        Meeting[] meetings = {meeting1, meeting2, meeting3};

//        Meeting meeting1 = new Meeting(7, 10);
//        Meeting meeting2 = new Meeting(2, 4);
//        Meeting[] meetings = {meeting1, meeting2};

        Meeting meeting1 = new Meeting(0, 10);
        Meeting meeting2 = new Meeting(5, 10);
        Meeting meeting3 = new Meeting(15, 20);
        Meeting meeting4 = new Meeting(15, 30);

        Meeting[] meetings = {meeting1, meeting2, meeting3, meeting4};

        System.out.println(solve(meetings));
    }

    static int solve(final Meeting[] meetings) {
        if (meetings == null || meetings.length <= 0) {
            return 0;
        }

        // 정렬
        Arrays.sort(meetings, Comparator.comparingInt(Meeting::getStart));

        // 회의실 목록을 회의 종료시간으로 정렬
        Queue<Meeting> rooms = new PriorityQueue<>(meetings.length, Comparator.comparingInt(Meeting::getEnd));

        rooms.offer(meetings[0]);

        final int size = meetings.length;
        for (int i = 1; i < size; i++) {
            Meeting beforeMeeting = rooms.poll();

            assert beforeMeeting != null;
            if (meetings[i].getStart() < beforeMeeting.getEnd()) {
                rooms.offer(meetings[i]);
            }

            rooms.offer(beforeMeeting);
        }

        return rooms.size();
    }
}
