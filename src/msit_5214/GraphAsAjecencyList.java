package msit_5214;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GraphAsAjecencyList {
	
	class Vertex {
		private String label;
		
		public Vertex(String label) {
			this.label = label;
		}
	}
	
    public int lengthOfLastWord(String s) {
        return s.trim().substring(s.trim().lastIndexOf(' ') + 1).length();
    }
	
	
	private Map<Vertex, List<Vertex>> adjacentVerticies;
	

	public static void main(String[] args) {
		Map<Integer, Integer> resultHolder = new HashMap<>();
		int[] input = {1,2,3,1};
		
		
		
		IntStream.of(input).forEach( item -> {
			resultHolder.merge(item, 1, Integer::sum);
		});
		
		resultHolder.forEach((K, V) -> {
			System.out.println("key:=" + K + ", value:=" + V);
		});

		GraphAsAjecencyList gal = new GraphAsAjecencyList();
		String s = "Hello World";
		System.out.println(gal.lengthOfLastWord(s));
		
	}

}
