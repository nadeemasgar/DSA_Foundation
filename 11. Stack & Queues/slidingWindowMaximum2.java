import java.io.*;
import java.util.*;

public class slidingWindowMaximum2 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        int[] ans = slidingWindow(a , k);

        //System.out.println(Arrays.toString(ans));

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] slidingWindow(int[] arr, int k) {

        int[] left = GreaterElementLeft(arr, k);
        System.out.println(Arrays.toString(left));

        int[] right = GreaterElementRight(arr, k);
        System.out.println(Arrays.toString(right));

        int[] kMax = new int[arr.length - k + 1];

        for (int i = 0; i < kMax.length; i++) {

            int max = Math.max(left[i + k - 1], right[i]);

            kMax[i] = max;
        }

        return kMax;
    }

    public static int[] GreaterElementRight(int[] arr, int k) {

        int[] right =  new int[arr.length];

        int maxElement = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            if ((i + 1) % (k) == 0) {
                maxElement = arr[i];
            } else {
                maxElement = Math.max(maxElement, arr[i]);
            }

            right[i] = maxElement;
        }

        return right;

    }

    public static int[] GreaterElementLeft(int[] arr, int k) {

        int[] left =  new int[arr.length];

        int maxElement = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i % (k) == 0) {
                maxElement = arr[i];
            } else {
                maxElement = Math.max(maxElement, arr[i]);
            }

            left[i] = maxElement;
        }

        return left;
    }


}