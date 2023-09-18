package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedComponent {
	static Scanner sc = new Scanner(System.in);
	static int n, m;

	static int[][] a = new int[1005][1005];
	static boolean[] visited = new boolean[1000];

	// bfs using queue // danh dau tat ca ca dinh co the di tu s
	static void bfs(int s) {
		// initial : danh dau tat ca ca din h chua dc tham
		visited[s] = true;
		Queue<Integer> q = new LinkedList<>();
		// them dinh s vao queue de bat dau duyet tu dinh s
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.poll(); // get and delete this
			// duyet qua cac dinh ke voi u
			for (int v = 1; v <= n; v++) {
				if (a[u][v] == 1 && visited[v] == false) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		int u, v;
		for (int i = 1; i <= m; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			a[u][v] = 1;
			a[v][u] = 1;
		}

		int dem = 0;

		for (int i = 1; i <= n; i++)
			visited[i] = false;

		// duyet tung dinh
		for (int i = 1; i <= n; i++) {
			// Đỉnh đó k nằm trong thanh phan lien thong da duyet
			if (visited[i] == false) {
				bfs(i);
				dem++;
			}
		}

		System.out.println(dem);
	}
}


