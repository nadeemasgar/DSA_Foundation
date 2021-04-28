import java.io.*;
import java.util.*;

public class OverlappingIntervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time

        //display(arr);

        sort(arr);

        //System.out.println("-------Sorted-------");

        //display(arr);

        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();

        start.push(arr[0][0]);
        end.push(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {

            int currStart = start.peek();
            int currEnd = end.peek();

            if (arr[i][0] > currEnd) {
                start.push(arr[i][0]);
                end.push(arr[i][1]);
            } else {
                currEnd = Math.max(currEnd, arr[i][1]);
                if (currEnd != end.peek()) {
                    end.pop();
                    end.push(currEnd);
                }
            }
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> e1 = new Stack<>();

        /*System.out.println(start);
        System.out.println(end);*/

        while (start.size() > 0) {
            s1.push(start.pop());
        }

        while (end.size() > 0) {
            e1.push(end.pop());
        }

        while (s1.size() > 0 && e1.size() > 0) {
            System.out.println(s1.pop() + " " + e1.pop());
        }


    }

    public static void sort(int[][] arr) {

        for (int itr = 1; itr < arr.length; itr++) {

            for (int j = itr; j > 0; j--) {

                if (arr[j - 1][0] > arr[j][0]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }

    }

    public static void swap(int[][] arr, int i , int j) {

        int temp1 = arr[i][0];
        int temp2 = arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = temp1;
        arr[j][1] = temp2;
    }

}