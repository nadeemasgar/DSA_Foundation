import java.io.*;
import java.util.*;

public class printAllPermutationsIteratively {

	public static int factorail(int length) {

		int mul = 1;
		for (int i = 1; i <= length; i++) {
			mul = mul * i;
		}

		return mul;
	}

	public static void solution(String str) {

		int length = str.length();
		int fact = factorail(length);

		for (int i = 0; i < fact; i++) {

			StringBuilder s = new StringBuilder(str);
			int div = i;

			for (int j = length; j > 0; j--) {

				int rem = div % j;
				div = div / j;

				char c = s.charAt(rem);
				System.out.print(c);
				s.deleteCharAt(rem);
			}

			System.out.println();
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}