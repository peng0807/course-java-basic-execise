package chapter5.ex8;

import java.util.HashSet;
import java.util.Scanner;

public class SplitWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		String[] words = sentence.split(" ");
		HashSet<String> set = new HashSet<String>();
		for (String word : words) {
			set.add(word);
		}
		for (String word : set) {
			System.out.println(word);
		}
		scanner.close();
	}

}
