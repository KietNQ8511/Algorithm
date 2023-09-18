package stack;

import java.util.Scanner;
import java.util.Stack;

public class NumberOfPair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] a = new int[1000005];
		int ans = 0;

		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		Stack<Integer> s1 = new Stack<>();
		for (int i = n; i >= 1; i--) {
			while (!s1.isEmpty() && s1.peek() < a[i]) {
				s1.pop();
			}
			if (!s1.isEmpty()) {
				ans++;
			}
			s1.push(a[i]);

		}

		Stack<Integer> s2 = new Stack<>();
		for (int i = 1; i <= n; i++) {
			while (!s2.isEmpty() && s2.peek() < a[i]) {
				s2.pop();
			}
			if (!s2.isEmpty() && s2.peek() != a[i]) {
				ans++;
			}
			s2.push(a[i]);
		}

		System.out.println(ans);
	}
}
