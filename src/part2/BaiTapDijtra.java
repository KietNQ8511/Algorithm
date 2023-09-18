package part2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BaiTapDijtra {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static char a[][] = new char[105][105];
	static int s1, s2, d1, d2;
	static int oo = 1000000000;

	static int dist[][] = new int[105][105];
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { -1, 1, 0, 0 };

	static boolean isValid(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m) {
			return false;
		}
		return true;
	}

	static void bfs(int x, int y) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dist[i][j] = oo;
			}
		}

		dist[x][y] = 0;

		Queue<Point> q = new PriorityQueue<>((u, v) -> {
			if (u.dist > v.dist)
				return 1;
			else
				return -1;
		});

		q.add(new Point(x, y, 0));
		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				int x1 = curPoint.x + dx[i];
				int y1 = curPoint.y + dy[i];
				Point newPoint = new Point(x1, y1, curPoint.dist + 1);
				if (a[x1][y1] == '+') {
					newPoint.dist = curPoint.dist + 4;
				}
				
				if (isValid(newPoint.x, newPoint.y) && dist[newPoint.x][newPoint.y] > newPoint.dist) {
					dist[newPoint.x][newPoint.y] = newPoint.dist;
					q.add(newPoint);
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String tmpString = sc.next();
			tmpString = " " + tmpString;
			for (int j = 1; j <= m; j++) {
				a[i][j] = tmpString.charAt(j);
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

		bfs(s1, s2);
 
		if (dist[d1][d2] == oo) {
			System.out.println(-1);
			return;
		}

		System.out.println(dist[d1][d2]);
	}
	
	
	static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
  
}
