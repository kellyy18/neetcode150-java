package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem0252_MeetingRooms {
    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /* Brute Force */
    // public static boolean canAttendMeetings(List<Interval> intervals) {
    //     int n = intervals.size();
    //     for (int i = 0; i < n; i++) {
    //         Interval A = intervals.get(i);
    //         for (int j = i + 1; j < n; j++) {
    //             Interval B = intervals.get(j);
    //             if ((B.start < A.end) && (B.end > A.start)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    /* Sorting */
    public boolean canAttendmeetings(List<Interval> intervals) {
        // Once you know this syntax it's really easy
        // Comparator takes in a key=lambda / anonymous function comparingInt
        // which will basically compare these integers by this property 'start'
        intervals.sort(Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            // If you think about it, once they're sorted by start time ...
            // The only way the interval overlaps is if the first meeting ends before the 
            // next meeting starts. Think of the meetings on a horizontal timeline with start and end 
            // drawn as line box / whisker plot without the box n whisper component I suppose
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem0252_MeetingRooms solution = new Problem0252_MeetingRooms();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(solution.new Interval(0, 30));
        intervals.add(solution.new Interval(5, 10));
        intervals.add(solution.new Interval(15, 20));

        boolean b = solution.canAttendmeetings(intervals);
        System.out.println(b); // false
    }
}
