package self;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestMatrix4 {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int a[][] = new int[105][105];
	static boolean[][] visited = new boolean[105][105];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] dist = new int[105][105];
	static int oo = 999999999;

	static int s1, s2, d1, d2;

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > m) {
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

		Point p = new Point(x, y);
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		visited[x][y] = true;
		dist[x][y] = 1;

		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[x][y] == false && a[newPoint.x][newPoint.y] != '+') {
					dist[newPoint.x][newPoint.y] = dist[curPoint.x][curPoint.y] + 1;
					visited[newPoint.x][newPoint.y] = true;
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
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
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
		/**
		 * 
		 */
		bfs(s1, s2);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(dist[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @author kiet.nguyen
	 *
	 */
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
