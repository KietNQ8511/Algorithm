package vetcan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int n;
		Lixi[] lxs = new Lixi[100];
		Scanner sc = new Scanner(System.in);
		List<Lixi> notAdd = new ArrayList<>();
		List<Lixi> add = new ArrayList<>();
		int curSum = 0;
		int curAdd = 1;

		/* ---------------------------------- */
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			lxs[i] = new Lixi();
			lxs[i].val = sc.nextInt();
			lxs[i].add = sc.nextInt();
		}
		/* ---------------------------------- */

		for (int i = 1; i <= n; i++) {
			if (lxs[i].add > 0) {
				add.add(lxs[i]);
			} else {
				notAdd.add(lxs[i]);
			}
		}

		notAdd.sort((a, b) -> b.val - a.val);

		for (Lixi e : add) {
			curAdd += e.add;
			curAdd--;
			curSum += e.val;
		}

		for (int i = 0; i < notAdd.size() && curAdd > 0; i++) {
			curSum += notAdd.get(i).val;
			curAdd--;
		}

		System.out.println(curSum);
	}
	
	static class Lixi {
		int val, add;

		Lixi(int val, int add) {
			this.val = val;
			this.add = add;
		}

		public Lixi() {
			// TODO Auto-generated constructor stub
		}
	}
}
