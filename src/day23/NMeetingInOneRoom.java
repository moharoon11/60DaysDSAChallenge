package day23;

import java.util.ArrayList;
import java.util.Collections;

public class NMeetingInOneRoom {


    class Meeting {

        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

    }
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.

    // TC: O(2n) + O(n log n)
    // SC: O(3 * n) + O(n)
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<Meeting> meet = new ArrayList<>();

        for(int i=0; i<n; i++) {
            meet.add(new Meeting(start[i], end[i], i+1));
        }

        Collections.sort(meet, (Meeting m1, Meeting m2) -> m1.end - m2.end);

        ArrayList<Integer> positions = new ArrayList<Integer>();
        int counter = 1;
        positions.add(meet.get(0).position);
        int freeTime = meet.get(0).end;

        for(int i=1; i<n; i++) {
            if(meet.get(i).start > freeTime) {
                counter += 1;
                freeTime = meet.get(i).end;
                positions.add(meet.get(i).position);
            }
        }

        return counter;
    }

}
