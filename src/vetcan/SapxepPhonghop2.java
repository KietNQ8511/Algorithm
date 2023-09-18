package vetcan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SapxepPhonghop2 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Meeting[] meetings = new Meeting[100];

	public void resolve() {
		for (int i = 1; i <= n; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			meetings[i] = new Meeting();
			meetings[i].start = sc.nextInt();
			meetings[i].end = sc.nextInt();
			meetings[i].cost = sc.nextInt();
		}

		
		Arrays.sort(meetings, 1, n + 1, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.end - o2.end;
			}
			
		});

			
		for(int i = 1; i <= n; i++) {
			System.out.println("start " + meetings[i].start + " end " + meetings[i].end + " cost " + meetings[i].cost);
		}
	}

	/* ============================ */
	static class Meeting {
		int start, end, cost;
	}
}
