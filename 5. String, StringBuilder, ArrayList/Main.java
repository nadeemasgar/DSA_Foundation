import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str) {

		StringBuilder s = new StringBuilder();
		int i;
		for ( i = 0; i < str.length() - 1; i++) {

			s.append(str.charAt(i));
			int diff =  str.charAt(i + 1) - str.charAt(i);
			s.append(diff);
		}

		s.append(str.charAt(i));

		return s.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}