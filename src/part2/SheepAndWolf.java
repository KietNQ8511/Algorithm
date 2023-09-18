package part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SheepAndWolf {
	static Scanner sc = new Scanner(System.in);
	static int[][] a = new int[105][105];
	static boolean[][] visited = new boolean[105][105];
	static int n, m;
//	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
//	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int demK, demV;
	static boolean isRaNgoai;

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

			if (a[curPoint.x][curPoint.y] == 'k')
				demK++;
			if (a[curPoint.x][curPoint.y] == 'v')
				demV++;

			for (int i = 0; i <= 3; i++) {

				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] != '#') {
					visited[newPoint.x][newPoint.y] = true;
					q.add(newPoint);
				}

				// khu vuc nay co the ra ngoai
				if (!isValid(newPoint)) {
					isRaNgoai = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String tmpString = sc.next();
			tmpString = "0" + tmpString;
			for (int j = 1; j <= m; j++) {
				a[i][j] = tmpString.charAt(j);
			}
		}

		int ansK = 0, ansV = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visited[i][j] == false && a[i][j] != '#') {
					demK = demV = 0;
					isRaNgoai = false;
					bfs(i, j);
					if (isRaNgoai == true) {
						ansK += demK;
						ansV += demV;
					} else if (demK > demV) {
						ansK += demK;
					} else {
						ansV += demV;
					}
				}
			}
		}

		System.out.println(ansK + " " + ansV);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
