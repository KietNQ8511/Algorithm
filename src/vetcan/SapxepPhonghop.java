package vetcan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SapxepPhonghop {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Meeting[] meetings = new Meeting[5000];
	static int result = 0;

	static void resolve() {

		int currentEndTime = 0;
		
		for (int i = 1; i <= n; i++) {
			if (meetings[i].start >= currentEndTime) {
				result += 1;
				currentEndTime = meetings[i].end;
			}
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
		
//		Arrays.sort(meetings, 1, n + 1, (o1, o2) -> (o1.end - o2.end));
		
		 

		resolve();

		System.out.println(result);
	}

	/* ============================ */
	static class Meeting {
		int start, end, cost;
	}

}
