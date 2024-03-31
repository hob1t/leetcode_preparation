package com.cato.exe;

import java.util.HashMap;
import java.util.Map;

/**
 * (-1,2)
(1,3)
(5,7)
(6,11)
(5.8, 10)
 */
public class Solver {
	// point A, max: 3
	public Map<Pair, Integer> calculateLineMeeting(Pair[] lines) {
		Map<Pair, Integer> holder = new HashMap<>();
		int counter = 0;
		for(int i = 0; i < lines.length; i++) {
			for(int j = 1; j < lines.length; j++) {
				if(lines[i].getX() < lines[j].getX() && lines[j].getX() < lines[i].getY()) {
					counter++;
				}
				// pair_1 pair_2
				// pair_1.getX() < pair_2.getX() < pair_1.getY() 
				// counter++;
			}
			holder.put(lines[i], counter);
			counter = 0;
		}
		
		return holder;
	}
	

	public static void main(String[] args) {
		Pair[] lines = { new Pair(-1, 2),  new Pair(1, 3), new Pair(5, 7), new Pair(6, 11), new Pair(5.8, 10)};

	}

}
