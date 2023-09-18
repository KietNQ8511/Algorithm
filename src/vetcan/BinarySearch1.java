package vetcan;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1 {
	static Scanner sc = new Scanner(System.in);
	static int n, q, x;
	static int[] a = new int[200005];
	static float[] avg = new float[200005];
	
	static public float avg(int idx) {
		int sum = 0;
		for (int i = 1; i <= idx; i++) {
			sum += a[i];
		}
		
		return (float)sum/idx;
	}
	
	static public void saveAVG() {
		float currentAvg = a[1];
		avg[1] = a[1];
		for (int i = 2; i <= n; i++) {
			avg[i] = (currentAvg + a[i]) / i;
			currentAvg = avg[i];
		}
	}
	
	static public void solve(int val) {
		int l = 1, r = n;
		boolean isHas = false;
		while(l <= r) {
			int mid = (l + r) / 2;
			if (avg[mid] < val) {
				if (mid != l) {
					l = mid + 1;
				} else {
					if (avg[mid + 1] < val) {
						System.out.println(mid + 1);
					} else {
						System.out.println(mid);
					}
					isHas = true;
					return;
				}
			} else {
				r = mid - 1;
			}
		}
		
		if (!isHas) {
			System.out.println(0);
		}
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a, 1, n + 1);
		saveAVG();
		q = sc.nextInt();

		for(int i = 1; i <= q; i++) {
			int x = sc.nextInt();
			solve(x);
		}
	}
}
