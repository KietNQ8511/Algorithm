package self;

import java.util.Arrays;
import java.util.Comparator;

public class A {
	public static void main(String[] args) {
		SS[] sss = new SS[10];
		sss[1] = new SS(4, "D");
		sss[2] = new SS(9, "E");
		sss[0] = new SS(6, "G");
		
		Arrays.sort(sss, 0, 3, new Comparator<SS>() {
			public int compare(SS s1, SS s2) {
				return s1.a - s2.a;
			};
		});

		for (int i = 0; i < 3; i++) {
			System.out.println(sss[i].a);
		}
	}

	static class SS {
		int a;
		String b;

		public SS(int a, String b) {
			// TODO Auto-generated constructor stub
			this.a = a;
			this.b = b;
		}
	}
}
