package stack;

import java.util.Scanner;

public class ProblemB {

	static Scanner sc = new Scanner(System.in);
	static int m, n;
	static int[][] a = new int[1005][1005];
	static long[] r = new long[1005];
	static long[] l = new long[1005];
	static long[] sum = new long[1005];

	public static void main(String[] args) {

		n = sc.nextInt();
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
				sum += a[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				r[i] = r[i] + a[i][j];
				l[j] += a[i][j];
			}
		}

		long max = 0;
		for (int i = 1; i <= n; i++) {

			if (max < r[i]) {
				max = r[i];
			}
			if (max < l[i]) {
				max = l[i];
			}
		}

		long rs = max * n - sum;
		System.out.println(rs);
	}

}
