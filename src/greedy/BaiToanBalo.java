package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaiToanBalo {
	
	static int n;
	static int w;
	static long ans = 0;

	static Package A[] = new Package[105];

	static void solve() {
		long curW = 0;
		long curV = 0;
		
		for (int i = 1; i <= n; i++) {
			if (curW + A[i].w <= w) {
				curW += A[i].w;
				curV += A[i].v;
			}
		}

		ans = Math.max(ans, curV);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			A[i] = new Package();
			A[i].w = sc.nextLong();
			A[i].v = sc.nextLong();
		}

		Arrays.sort(A, 1, n + 1,new Comparator<Package>() {

			@Override
			public int compare(Package o1, Package o2) {
				return (int) (o1.w - o2.w);
			}

		});

		solve();

		Arrays.sort(A, 1, n + 1,new Comparator<Package>() {

			@Override
			public int compare(Package o1, Package o2) {
				return (int) (o2.v - o1.v);
			}

		});
		
		solve();
		
		Arrays.sort(A, 1, n + 1,new Comparator<Package>() {

			@Override
			public int compare(Package o1, Package o2) {
				return (int) (o2.v/o2.w - o1.v/o1.w);
			}
			
		});
		
		solve();
		
		
		System.out.println(ans);

	}
	
	public static class Package {
		long w, v;
	}

}
