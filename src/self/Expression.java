package self;

import java.util.Arrays;
import java.util.Scanner;

public class Expression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();

		int a[] = new int[100005];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a, 2, n + 1);

		long sum = a[1];
		
		int index = n;

		while (k-- > 0) {
			sum += a[index];
			index--;
		}

		for (int i = 2; i <= index; i++) {
			sum -= a[i];
		}

		System.out.println(sum);
		
	}
}
