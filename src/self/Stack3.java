package self;

import java.util.Scanner;

public class Stack3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] a = new int[100005];
		int[] rs = new int[100005];

		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		boolean discount;
		
		for (int i = 1; i <= n; i++) {
			discount = false;
			for (int j = i + 1; j <= n; j++) {
				if (a[i] >= a[j]) {
					discount = true;
					rs[i] = a[i] - a[j];
					break;
				}
				
			}
			if (!discount) {
				rs[i] = a[i];
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(rs[i] + " ");
		}
	}
}

// have discount: if you buy the ith item, have discount equivalent to prices[j] where j is the minimum index such that j > i
// and prices [j] <= prices[i]. you will not receive any discount at all

//return an integer array answer[i] is the final price