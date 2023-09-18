package stack;

import java.util.Scanner;

public class Stack1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int a[] = new int[100005];
		int rs[] = new int[100005];
		n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
	}
}
