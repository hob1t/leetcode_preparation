package msit_5214;

import java.util.Stack;

/**
 * You are given a license key represented as a string s that consists of only
 * alphanumeric characters and dashes. The string is separated into n + 1 groups
 * by n dashes. You are also given an integer k.
 * 
 * We want to reformat the string s such that each group contains exactly k
 * characters, except for the first group, which could be shorter than k but
 * still must contain at least one character. Furthermore, there must be a dash
 * inserted between two groups, and you should convert all lowercase letters to
 * uppercase.
 * 
 * Return the reformatted license key.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "5F3Z-2e-9-w", k = 4 Output: "5F3Z-2E9W" Explanation: The string s
 * has been split into two parts, each part has 4 characters. Note that the two
 * extra dashes are not needed and can be removed.
 * 
 * Example 2:
 * 
 * Input: s = "2-5g-3-J", k = 2 Output: "2-5G-3J" Explanation: The string s has
 * been split into three parts, each part has 2 characters except the first part
 * as it could be shorter as mentioned above.
 * 
 */
public class EasyFormattingPlate {

	public String licenseKeyFormatting(String s, int k) {
		// idea, start from the end of the string, count k chars, removing -
		// them compose then and save in stack. Then after, pop all from stack and
		// combine with -
		
		char[] plate = s.toCharArray();
		Stack<String> holder = new Stack<>();
		
		int index = plate.length - 1;
		StringBuffer sb = new StringBuffer();
		
		while(index >= 0) {
		    if(sb.length() < k) {
		    	if(plate[index] != '-') {
		    		sb.append(plate[index]);
		    	}
		    	
		    } else {
		    	holder.add(sb.reverse().toString());
		    	sb.setLength(0);
		    }
		    index--;
		}
		
		if(sb.length() > 0) {
			holder.add(sb.reverse().toString());
		}
		
		sb.setLength(0);
		
		while(!holder.empty()) {
			sb.append(holder.pop());
			if(!holder.empty()) {
				sb.append('-');
			}
		}
		
		
		return sb.toString();

	}

	public static void main(String[] args) {
		EasyFormattingPlate runner = new EasyFormattingPlate();
		String palte = "2-5g-3-J";
		int k = 2;
		String result = runner.licenseKeyFormatting(palte, k);
		System.out.println("New plate " + result);

	}

}
