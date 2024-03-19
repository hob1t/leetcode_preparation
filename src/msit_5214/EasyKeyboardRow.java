package msit_5214;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Example 1:
 * 
 * Input: words = ["Hello","Alaska","Dad","Peace"] Output: ["Alaska","Dad"]
 * 
 * Example 2:
 * 
 * Input: words = ["omk"] Output: []
 * 
 * Example 3:
 * 
 * Input: words = ["adsdf","sfd"] Output: ["adsdf","sfd"]
 * 
 */
public class EasyKeyboardRow {
	public String[] findWords(String[] words) {
		List<String> result = new ArrayList<>();
		// 1. Map of sorted strings of lines
		// 2. Sort output
		// 3. Take a first letter and return line
		// 4. From the second letter, do search on this line
		// if exact match exists, put into result
		Set<String> keyboard = new HashSet<>();
		keyboard.add(Stream.of("qwertyuiop".split("")).sorted().collect(Collectors.joining()));
		keyboard.add(Stream.of("asdfghjkl".split("")).sorted().collect(Collectors.joining()));
		keyboard.add(Stream.of("zxcvbnm".split("")).sorted().collect(Collectors.joining()));

		for (int i = 0; i < words.length; i++) {
			// sort letters
			String searchKey = Stream.of(words[i].toLowerCase().split("")).sorted().collect(Collectors.joining());
			String line = getLine(searchKey, keyboard);

			if (!line.isEmpty()) {
				int counter = 0;
				for (Character ch : searchKey.toCharArray()) {
					if (line.indexOf(ch) >= 0) {
						counter++;
					}
				}

				if (counter == searchKey.length()) {
					result.add(words[i]);
				}
			}
		}

		String[] list = (String[]) result.stream().toArray(String[]::new);
		return list;
	}

	private String getLine(String searchKey, Set<String> keyboard) {
		for (String aLine : keyboard) {
			if (aLine.indexOf(searchKey.toCharArray()[0]) >= 0) {
				return aLine;
			}
		}

		return "";
	}

	public static void main(String[] args) {
		EasyKeyboardRow runner = new EasyKeyboardRow();
		String[] words = {"adsdf","sfd"};
		String[] result = runner.findWords(words);
		Stream.of(result).forEach(System.out::println);
	}

}
