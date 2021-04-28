import java.io.*;
import java.util.*;

public class stateOfWakanda {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        //System.out.println(n + "  " + m);

        //System.out.println(Arrays.toString(arr[0]));

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                arr[i][j] = scn.nextInt();
            }
        }


        for (int i = 0; i < arr[0].length; i++) {

            if (i % 2 == 0) {

                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                }
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }

}