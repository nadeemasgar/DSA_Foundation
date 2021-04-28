import java.io.*;
import java.util.*;

public class printAllPalindromicSubstrings {

	public static void solution(String str) {

		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j <= str.length(); j++) {

				String s2 = str.substring( i , j);
				checkPalindrome(s2);
			}
		}

	}

	public static void checkPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			if (s.charAt(start) != s.charAt(end)) {
				return;
			}

			start++;
			end--;
		}

		System.out.println(s);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}