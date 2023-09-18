package self;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Stack2Code_Theo_Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int a[] = new int[100005];

		int rs[] = new int[100005];
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		List<Integer> rss = new ArrayList<>();

		Stack<Integer> s = new Stack<>();
		
		int i = 2;
		int cnt = n;
		
		while (cnt > 0) {
			if (i == n) i = 1;
			
			while (!s.isEmpty() && a[i] < s.peek()) {
				rss.add(s.pop());
				cnt--;
			}
			
			
		}
		
		System.out.println(rss);
	}
}
// 1 2 1 3 4 3
