package self;

import java.util.Scanner;

public class NumberOfPair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] a = new int[1000005];
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		boolean isTrue;
		int output = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				isTrue = true;

				for (int k = i + 1; k < j; k++) {
					if (a[k] >= a[i] || a[k] >= a[j]) {
						isTrue = false;
						break;
					}
				}

				if (isTrue) {
					output++;
				}
			}
		}

		System.out.println(output);
	}

}

// 5 1 2 6 5 7
// 12, 13, 14, 15 break;
