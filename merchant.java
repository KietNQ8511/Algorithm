// Merchant
// https://eolymp.com/problems/224
package c770277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class B {
	static int n;
	static int m;
	static double maxCost = Double.MAX_VALUE;
	// hang hoa // apple, diamon, silk
	static int[] hang = new int[3];
	// unit price // apple, diamon, silk
	static int[] price = new int[3];
	// tax of cities
	static Map<Integer, Integer[]> cityTax = new HashMap<Integer, Integer[]>();

	// path + price
	static List<Edge>[] edges = new ArrayList[1005];

	static void bfs() {
		for (int mask = 1; mask < 1 << 3; mask++) {

		}

		// reset cost
		double[] cost = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			cost[i] = maxCost;
		}
		cost[1] = 0;
		Queue<Edge> q = new LinkedList<B.Edge>();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1st line
		n = sc.nextInt(); // n = 5 = 3
		m = sc.nextInt();

		// 2nd line
		hang[0] = sc.nextInt();
		hang[1] = sc.nextInt();
		hang[2] = sc.nextInt();

		// 3rd line
		price[0] = sc.nextInt();
		price[1] = sc.nextInt();
		price[2] = sc.nextInt();

		//
		for (int i = 2; i <= n - 1; i++) {
			int appleTax = sc.nextInt();
			int diamonTax = sc.nextInt();
			int silkTax = sc.nextInt();
			cityTax.put(i, new Integer[] { appleTax, diamonTax, silkTax });
		}

		for (int i = 0; i < m; i++) {
			edges[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}

	}

	static class Edge {
		int to, w;

		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
}

/**
 * - nối các thành phố - Mỗi thành phố áp một khoản thuế đối với từng loại
 * hàng hóa mà anh ta mang qua, được tính bằng tỷ lệ phần trăm (%) giá trị của
 * sản phẩm - Anh ta không bắt buộc phải mang theo tất cả hàng hóa của mình -
 * Thương gia luôn có đủ vàng để nộp thuế và không được phép dùng hàng hóa đang
 * mang theo để thay thế tiền thuế. - Tất cả các con đường đều là đường một
 * chiều
 */
