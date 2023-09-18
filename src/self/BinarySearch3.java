package self;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch3 {
	public static void main(String[] args) {
		int[] a = new int[100005];
		int n;
		int Q;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a, 1, n + 1);
		
		Q = sc.nextInt();
		int K[] = new int[Q+1];
		
		
		for (int i = 1; i <= Q; i++) {
			K[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= Q; i++) {
			int l = 1;
			int r = n;
			int mid;
			
			int pos = -1;
			while (l <= r) {
				mid = (l + r) / 2;
				if (a[mid] < K[i]) {
					pos = mid;
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			
			if (pos == -1) {
				System.out.println("NONE");
			} else {
				System.out.println(a[pos]);
			}
		}
		
	}
}
