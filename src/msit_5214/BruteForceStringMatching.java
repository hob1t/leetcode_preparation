package msit_5214;

public class BruteForceStringMatching {
	
	public int search(String text, String pattern) {
		int patInx;
		
		for(int inx = 0; inx <= (text.length() - pattern.length()); inx++) {
			patInx = 0;
			
			while(patInx < pattern.length() && pattern.charAt(patInx) == text.charAt(inx + patInx)) {
			    patInx++;	
			}
			
			if(patInx == pattern.length()) {
				return inx;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "BAAABAA";
		BruteForceStringMatching test = new BruteForceStringMatching();
		
		int result = test.search(text, pattern);

		System.out.print("Result goes to " + result);
	}
}
