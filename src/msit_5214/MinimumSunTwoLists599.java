package msit_5214;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the
 * least index sum.
 * 
 * A common string is a string that appeared in both list1 and list2.
 * 
 * A common string with the least index sum is a common string such that if it
 * appeared at list1[i] and list2[j] then i + j should be the minimum value
 * among all the other common strings.
 * 
 * Return all the common strings with the least index sum. Return the answer in
 * any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 =
 * ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"] Explanation: The only common string is "Shogun".
 * 
 * Example 2:
 * 
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 =
 * ["KFC","Shogun","Burger King"] Output: ["Shogun"] Explanation: The common
 * string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * 
 * Example 3:
 * 
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"] Output:
 * ["sad","happy"] Explanation: There are three common strings: "happy" with
 * index sum = (0 + 1) = 1. "sad" with index sum = (1 + 0) = 1. "good" with
 * index sum = (2 + 2) = 4. The strings with the least index sum are "sad" and
 * "happy".
 * 
 */
public class MinimumSunTwoLists599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> holder = new HashMap<>();
        Map<String, Integer> map1 = arrayToMap(list1);
        Map<String, Integer> map2 = arrayToMap(list2);
        int min = Integer.MAX_VALUE;
        
        for(String key : map1.keySet()) {
        	if(map2.containsKey(key)) {
        		System.out.println("Key_1:= " + map1.get(key) + ", inx_2: " + map2.get(key));
    			holder.put(key, map1.get(key) + map2.get(key));
    			min = Math.min(min, map1.get(key) + map2.get(key));
    			System.out.println("Min:= " + min);
    		}
        }

        for(String key : holder.keySet()) {
        	if(holder.get(key) == min) {
        		result.add(key);
        	}
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    Map<String, Integer> arrayToMap(String[] list) {
    	Map<String, Integer> orderedSet = new HashMap<>();
    	for(int inx = 0; inx < list.length; inx++) {
    		if(!orderedSet.containsKey(list[inx])) {
    			orderedSet.put(list[inx], inx);
    		} else {
    			orderedSet.merge(list[inx], 1, Integer::sum);
    		}
    	}
    	
    	
		return orderedSet;
    	
    }

	public static void main(String[] args) {
		MinimumSunTwoLists599 runner = new MinimumSunTwoLists599();
		String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[]list2 = {"KFC","Shogun","Burger King"};
		
		String[] result = runner.findRestaurant(list1, list2);
		Stream.of(result).forEach(el -> {
			System.out.println(el);
		});
	}

}
