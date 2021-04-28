import java.io.*;
import java.util.*;

public class slidingWindowMaximum {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());

		int[] ans = slidingWindow(a, k);
		//System.out.println(Arrays.toString(ans));
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	public static int[] slidingWindow(int[] arr, int k) {

		int[] ngr = nextGreaterRight(arr);
		//System.out.println(Arrays.toString(ngr));

		int[] kMax = new int[arr.length - k + 1];

		for (int i = 0; i <= ngr.length - k; i++) {
			int maxIndx = i;

			for (int j = i; j < i + k; j++) {
				if (ngr[j] < i + k) {
					maxIndx = ngr[j];
				} else {
					break;
				}
			}

			kMax[i] = arr[maxIndx];
		}

		return kMax;
	}


	public static int[] nextGreaterRight(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] ans = new int[arr.length];

		Arrays.fill(ans, arr.length);
		st.push(0);

		for (int i = 1; i < arr.length; i++) {
			int val = arr[i];
			while (st.size() > 0 && arr[st.peek()] < val) {
				int idx = st.pop();
				ans[idx] = i;
			}

			st.push(i);
		}

		return ans;
	}

}