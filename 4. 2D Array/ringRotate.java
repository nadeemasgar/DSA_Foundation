import java.io.*;
import java.util.*;

public class ringRotate {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int r = scn.nextInt();

        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        int totalElement = 2 * ((maxr - minr) + (maxc - minc));

        int[] arr2 = new int[totalElement];

        r = r % totalElement;

        if (r < 0) {
            r += totalElement;
        }

        int count = 0;
        int k = 0;

        while (count < totalElement) {

            // Top wall
            for (int i = minr, j = minc; j <= maxc && count < totalElement; j++) {
                arr2[k] = arr[i][j];
                k++;
                count++;
            }

            // Right wall
            for (int i = minr + 1, j = maxc; i <= maxr && count < totalElement; i++) {
                arr2[k] = arr[i][j];
                k++;
                count++;
            }

            // Bottom wall
            for (int i = maxr, j = maxc - 1; j >= minc && count < totalElement; j--) {
                arr2[k] = arr[i][j];
                k++;
                count++;
            }

            // Left wall
            for (int i = maxr - 1, j = minc; i >= minr && count < totalElement; i--) {
                arr2[k] = arr[i][j];
                k++;
                count++;
            }
        }

        rotate(arr2, r);

        count = 0;
        k = 0;

        while (count < totalElement) {

            // Top wall
            for (int i = minr, j = minc; j <= maxc && count < totalElement; j++) {
                arr[i][j] = arr2[k];
                k++;
                count++;
            }

            // Right wall
            for (int i = minr + 1, j = maxc; i <= maxr && count < totalElement; i++) {
                arr[i][j] = arr2[k];
                k++;
                count++;
            }

            // Bottom wall
            for (int i = maxr, j = maxc - 1; j >= minc && count < totalElement; j--) {
                arr[i][j] = arr2[k];
                k++;
                count++;
            }

            // Left wall
            for (int i = maxr - 1, j = minc; i >= minr && count < totalElement; i--) {
                arr[i][j] = arr2[k];
                k++;
                count++;
            }
        }

        display(arr);

    }

    public static void rotate(int[] arr, int r) {

        reverse(arr, 0, r - 1);
        reverse(arr, r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int left, int right) {

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}