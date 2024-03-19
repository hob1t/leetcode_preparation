package msit_5214;

/**
 * You are given a string s representing an attendance record for a student
 * where each character signifies whether the student was absent, late, or
 * present on that day. The record only contains the following three characters:
 * 
 * 'A': Absent. 'L': Late. 'P': Present.
 * 
 * The student is eligible for an attendance award if they meet both of the
 * following criteria:
 * 
 * The student was absent ('A') for strictly fewer than 2 days total. The
 * student was never late ('L') for 3 or more consecutive days.
 * 
 * Return true if the student is eligible for an attendance award, or false
 * otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "PPALLP" Output: true Explanation: The student has fewer than 2
 * absences and was never late 3 or more consecutive days.
 * 
 * Example 2:
 * 
 * Input: s = "PPALLL" Output: false Explanation: The student was late 3
 * consecutive days in the last 3 days, so is not eligible for the award.
 * 
 */
public class EasyStudentAttendanceOne {

	public boolean checkRecord(String s) {
		// idea two counters, for A and for L
		// if we met A or P we reset L
		int counterA = 0, counterL = 0;

		for (char ch : s.toCharArray()) {
			if (ch == 'A') {
				if (++counterA > 1) {
					counterL = 0;
					return false;
				} 
				
			} else if (ch == 'L') {
				if (++counterL > 2) {
					return false;
				}
				
			} else {
				counterL = 0;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		EasyStudentAttendanceOne runner = new EasyStudentAttendanceOne();
		String input = "PPALLP";
		boolean result = runner.checkRecord(input);
		System.out.println("Result:= " + result);
	}
}
