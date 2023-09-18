package part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaoVeNongTrang {
	static Scanner sc = new Scanner(System.in);
	static int[][] a = new int[105][105];
	static boolean[][] visited = new boolean[105][105];
	static boolean isDinhNui;
	static int n, m;
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

//	static int[] dx = { 0, 0, -1, 1 };
//	static int[] dy = { -1, 1, 0, 0 };

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > m) {
			return false;
		}

		return true;
	}

	static void bfs(int x, int y) {

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 7; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false
						&& a[curPoint.x][curPoint.y] == a[newPoint.x][newPoint.y]) {
					visited[newPoint.x][newPoint.y] = true;
					q.add(newPoint);
				}

				if (isValid(newPoint) && a[newPoint.x][newPoint.y] > a[curPoint.x][curPoint.y]) {
					isDinhNui = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i][j] > 0 && visited[i][j] == false) {
					isDinhNui = true;
					bfs(i, j);
					if (isDinhNui) {
						count++;
					}
				}
			}
		}

		System.out.println(count);

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
