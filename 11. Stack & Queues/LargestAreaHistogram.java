import java.io.*;
import java.util.*;

public class LargestAreaHistogram {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // Next smaller on right
        int[] nsr = NextSmallerElementOnRight(a);
        //System.out.println(Arrays.toString(nsr));

        // Next smaller on left
        int[] nsl = NextSmallerElementOnLeft(a);
        //System.out.println(Arrays.toString(nsl));

        int maxArea = 0;

        for (int i = 0; i < a.length; i++) {

            int initial = nsl[i];
            int Final = nsr[i];

            int area = a[i] * ((Final - initial) - 1);

            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    public static int[] NextSmallerElementOnRight(int[] arr) {

        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);

        Arrays.fill(ans, arr.length);

        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            while (st.size() > 0 && arr[st.peek()] > val) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        return ans;
    }

    public static int[] NextSmallerElementOnLeft(int[] arr) {

        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        Arrays.fill(ans, -1);

        for (int i = arr.length - 2; i >= 0; i--) {
            int val = arr[i];
            while (st.size() > 0 && arr[st.peek()] > val) {
                int idx = st.pop();
                ans[idx] = i;
            }

            st.push(i);
        }

        return ans;
    }
}