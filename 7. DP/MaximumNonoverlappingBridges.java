import java.util.*;
import java.lang.*;

class MaximumNonoverlappingBridges {
	static class Pair implements Comparable<Pair> {

		int north;
		int south;

		public Pair(int north, int south) {
			this.north = north;
			this.south = south;
		}

		public int compareTo(Pair o) {

			if (this.north != o.north) {
				return this.north - o.north;
			} else {
				return this.south - o.south;//**********************
			}
		}
	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		//int testcase = scn.nextInt();

		//while (testcase-- > 0) {

		int n = scn.nextInt();
		int[][] arr = new int[n][2];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				arr[i][j] = scn.nextInt();
			}
		}

		Pair[] p = new Pair[n];

		for (int i = 0; i < n; i++) {
			p[i] = new Pair(arr[i][0], arr[i][1]);
		}

		Arrays.sort(p);

		int[] dp = new int[n];

		Arrays.fill(dp, 1);

		int omax = 1;

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (p[j].south <= p[i].south && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}

			omax = Math.max(omax, dp[i]);
		}

		System.out.println(omax);
	}
	//}
}