package self;

import java.util.Scanner;
import java.util.Stack;

public class NumberOfPairStack {
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
		for (int i = 1; i <= n; i++) {
			while(!s1.isEmpty() && s1.peek() < a[i]) {
				s1.pop();
			}
			
			while (!s1.isEmpty() && s1.peek() != a[i]) {
				
			}
			s1.push(a[i]);
		}
	}
}

//5 1 2 6 4 7
//5 1 


