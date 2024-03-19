package msit_5214;

/**
 * 
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * 
 * Example 1:
 * 
 * Input: columnNumber = 1 Output: "A"
 * 
 * Example 2:
 * 
 * Input: columnNumber = 28 Output: "AB"
 * 
 * Example 3:
 * 
 * Input: columnNumber = 701 Output: "ZY"
 * 
 * 
 * 
 */
public class ExcelColumnTitle {
	private final static int NUM_LETTERS = 26;
	
    public String convertToTitle(int columnNumber) {
    	if(columnNumber <= 26) {
    		char fChar = (char) (columnNumber - 1 + 'A');
        	return String.valueOf(fChar);
    	}
    	
    	int firstNum = columnNumber / NUM_LETTERS;
    	char fChar = (char) (firstNum - 1 + 'A');

    	int secondNum = columnNumber % NUM_LETTERS;
    	char sChar = (char) (secondNum - 1 + 'A');
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append(fChar).append(sChar);
    	
    	return sb.toString();
    }

	public static void main(String[] args) {
		ExcelColumnTitle runner = new ExcelColumnTitle();
		
        System.out.println(runner.convertToTitle(701));
	}

}
