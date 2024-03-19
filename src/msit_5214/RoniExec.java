package msit_5214;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RoniExec {

	
	static <E> E getRandomSetElement(Set<E> set) {
	    return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
	}
	
	public static void main(String[] args) {
		Set<Integer> savivon = new HashSet<>();
		savivon.add(9);
		savivon.add(8);
		savivon.add(7);
		savivon.add(6);
		

		Set<Integer> luah = new HashSet<>();
		luah.add(0);
		luah.add(1);
		luah.add(10);
		luah.add(20);
		luah.add(9);
		luah.add(2);
		luah.add(3);
		luah.add(4);
		luah.add(5);
		luah.add(6);
		luah.add(7);
		luah.add(8);
		
		int numberOnSavivon = getRandomSetElement(savivon);
		int numberOnLuah = getRandomSetElement(luah);
		
		System.out.println("Number on Savivon is: " + numberOnSavivon);
		System.out.println("Number on luah is: " + numberOnLuah);
	}

}
