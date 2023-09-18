package part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumKnightMove {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int s1, s2, d1, d2;
	static int oo = 100000000;
	static int[][] dist = new int[105][105];
	static boolean visited[][] = new boolean[105][105];
	static int dx[] = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dy[] = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 };

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > 8 || p.y <= 0 || p.y > 8) {
			return false;
		}

		return true;
	}

	static void bfs(int x, int y) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				dist[i][j] = oo;
				visited[i][j] = false;
			}
		}

		dist[x][y] = 0;
		visited[x][y] = true;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point curPoint = queue.poll();

			for (int i = 0; i <= 7; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);

				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false) {
					visited[newPoint.x][newPoint.y] = true;
					dist[newPoint.x][newPoint.y] = dist[curPoint.x][curPoint.y] + 1;
					queue.add(newPoint);
				}
			}
		}
	}

	public static void main(String[] args) {
		int T = sc.nextInt();
		while (T-- > 0) {
			String s1, s2;
			s1 = sc.next();
			s2 = sc.next();
			int t1, t2, d1, d2;
			t1 = s1.charAt(0) - 'a' + 1;
			t2 = s1.charAt(1) - '0';
			d1 = s2.charAt(0) - 'a' + 1;
			d2 = s2.charAt(1) - '0';

			// ti duong di ngan nhat giua (t1, t2) => (d1, d2)
			bfs(t1, t2);
			// output: dist
			System.out.println(dist[d1][d2]);
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
