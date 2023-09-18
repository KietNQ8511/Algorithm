package self;

import java.util.Scanner;

public class Stack2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int a[] = new int[100005];

		int rs[] = new int[100005];
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		boolean isTrue;
		for (int i = 1; i <= n; i++) {
			isTrue = false;
			for (int j = i + 1; j <= n; j++) {
				if (a[i] < a[j]) {
					isTrue = true;
					rs[i] = a[j];
					break;
				}

			}

			if (!isTrue) {
				for (int j = 1; j <= i; j++) {
					if (a[i] < a[j]) {
						isTrue = true;
						rs[i] = a[j];
						break;
					}
				}
			}
			if (!isTrue) {
				rs[i] = -1;
			}

		}

		for (int i = 1; i < n; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println(rs[n]);
	}
}
