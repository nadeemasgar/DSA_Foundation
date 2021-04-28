import java.io.*;
import java.util.*;

public class toggle_Case {

	public static String toggleCase(String str) {

		StringBuilder s = new StringBuilder(str);

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {

				char c = (char)(ch - 32);
				s.setCharAt(i, c);
			} else {

				char c = (char)(ch + 32);
				s.setCharAt(i, c);
			}
		}

		return s.toString();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}