package vetcan;

import java.util.Scanner;

public class Knapsack {

	static Scanner sc = new Scanner(System.in);
	static long n;
	static long G[] = new long[105];
	static long W[] = new long[105];
	static long V[] = new long[105];
	static long w;
	static long ans = 0;

	static void output() {
		int curW = 0;
		int curV = 0;
		for (int i = 1; i <= n; i++) {
			if (G[i] == 1) {
				curW += W[i];
				curV += V[i];
			}
		}
		if (curW <= w) {
			ans = Math.max(ans, curV);
		}
	}

	static void gen(int i, long n) {
		for (int j = 0; j <= 1; j++) {
			G[i] = j;
			if (i < n)
				gen(i + 1, n);
			else
				output();
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		w = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}

		gen(1, n);
		System.out.println(ans);
	}
}
