import java.io.*;
import java.util.*;

public class exitPointOfAMatrix {

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

		int row = 0;
		int col = 0;


		while (true) {
			//East
			while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 0 ) {
				col++;
			}
			if (!(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length))
				break;
			row++;

			//south
			while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 0 ) {
				row++;
			}
			if (!(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length))
				break;
			col--;

			//west
			while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 0 ) {
				col--;
			}
			if (!(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length))
				break;
			row--;

			//north
			while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 0 ) {
				row--;
			}
			if (!(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length))
				break;
			col++;



		}
		if (row == arr.length)
			row--;
		if (row < 0)
			row++;
		if (col == arr[0].length)
			col--;
		if (col < 0)
			col++;



		System.out.println(row);
		System.out.println(col);
	}

}
