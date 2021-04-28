import java.io.*;
import java.util.*;

public class removePrimes {

	public static boolean checkPrime(int val) {

		for (int i = 2; i * i <= val; i++) {

			if (val % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void solution(ArrayList<Integer> list) {

		for (int i = list.size() - 1; i >= 0; i--) {

			int val = list.get(i);
			boolean bool = checkPrime(val);
			if (bool == true) {
				list.remove(i);
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0 ; i < n; i++) {
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}