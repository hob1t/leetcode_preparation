package msit_5214;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[0,30],[5,10],[15,20]] Output: false
 * 
 * Example 2:
 * 
 * Input: intervals = [[7,10],[2,4]] Output: true
 * 
 * Idea:
 * 1. Sort intervals by start
 * 2. Compare first interval end with second interval start. If si.start less than fi.end then return false
 * 
 */
public class EasyMeetingRoom {
	class Interval {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
	}
	
	public boolean canAttendMeetings(Interval[]intervals) {
		// 1. sort by start key
		// compare f.end > s.start 
		// start with index 1
		Arrays.sort(intervals, (a, b) -> a.start - b.end);
		
		for(int inx = 1; inx < intervals.length; inx++) {
			Interval fi = intervals[inx - 1];
			Interval si = intervals[inx];
			
			if(fi.end > si.start) {
				return false;
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		EasyMeetingRoom runner = new EasyMeetingRoom();
		Interval[] input = {runner.new Interval(0, 30), runner.new Interval(5, 10), runner.new Interval(15, 20)};
        System.out.println(runner.canAttendMeetings(input));
        
        Interval[] input2 = {runner.new Interval(7, 10), runner.new Interval(2, 4), runner.new Interval(4, 7)};
        System.out.println(runner.canAttendMeetings(input2));
	}

}
