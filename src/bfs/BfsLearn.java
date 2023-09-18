package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BfsLearn {
	static Scanner sc = new Scanner(System.in);
	static int n, m;

	static int[][] a = new int[105][105];
	static boolean[] visited = new boolean[105];

	// bfs using queue  // danh dau tat ca ca dinh co the di tu s
	static void bfs(int s) {
		// initial : danh dau tat ca ca din h chua dc tham
		for (int i = 1; i <= n; i++)
			visited[i] = false;
		visited[s] = true;
		Queue<Integer> q = new LinkedList<>();
		// them dinh s vao queue de bat dau duyet tu dinh s
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.poll(); // get and delete this
			// duyet qua cac dinh ke voi u
			System.out.println(u);
			for (int v = 1; v <= n; v++) {
				if (a[u][v] == 1 && visited[v] == false) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
	}

	// bfs2 using stack
	static void bfs2(int s) {
		// initial : danh dau tat ca ca dinh chua dc tham
		for (int i = 1; i <= n; i++)
			visited[i] = false;
		visited[s] = true;
		Stack<Integer> q = new Stack<>();
		// them dinh s vao queue de bat dau duyet tu dinh s
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.pop(); // get and delete this
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
		// bfs using queue
		 bfs(1);

		// bfs using stack
		// bfs2(1);
		
	}

}
