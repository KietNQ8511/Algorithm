package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsShortestPath {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int a[][] = new int[255][255];
	static int s1, s2, d1, d2;
	static int oo = 1000000000;
	static int dist[][] = new int[255][255];
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static boolean[][] visited = new boolean[255][255];

	static boolean isValid(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m) {
			return false;
		}
		return true;
	}

	static void bfs(int x, int y, int level) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a[x][y]);
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int x1 = q.poll();
			for (int y1 = 1; x <= n; x++) {
				if (isValid(x1, y1) && visited[x1][y1] == false && a[x1][y1] < level) {
					q.add(y1);
					visited[x1][y1] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String tmpStr = sc.next();
			tmpStr = " " + tmpStr;
			for (int j = 1; j <= m; j++) {
				a[i][j] = tmpStr.charAt(j);
				if (a[i][j] == 'S') {
					s1 = i;
					s2 = j;
				}
				if (a[i][j] == 'D') {
					d1 = i;
					d2 = j;
				}
			}
		}

		for (int level = 0; level <= 1000; level++) {
			// tim kiem thanh phan lien thong > level
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (visited[i][j] == false) {
						bfs(i, j, level);
						cnt++;
					}
				}
			}
			
			if (cnt >= 2) {
				System.out.println(level);
				return;
			}
		}
		
//		bfs(s1, s2);
		System.out.println(dist[d1][d2]);

	}

}
