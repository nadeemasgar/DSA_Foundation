import java.io.*;
import java.util.*;

public class stringCompression {

	public static String compression1(String str) {

		String ans = "";
		ans += str.charAt(0);
		int j = 0;

		for (int i = 1; i < str.length(); i++) {

			if (str.charAt(i) != ans.charAt(j)) {
				ans += str.charAt(i);
				j++;
			}
		}

		return ans;
	}

	public static String compression2(String str) {

		String ans = "";
		ans += str.charAt(0);
		int j = 0;
		int count = 1;

		for (int i = 1; i < str.length(); i++) {

			if (ans.charAt(j) == str.charAt(i)) {
				count++;
			} else {
				if (count > 1) {
					ans += count;
					int length = (count + "").length();
					j += length;
				}

				ans += str.charAt(i);
				j++;

				count = 1;
			}
		}

		if (count > 1) {
			ans += count;
		}

		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}