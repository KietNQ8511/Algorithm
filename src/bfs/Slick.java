package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Slick {
	static Scanner sc = new Scanner(System.in);
	static int m, n;
	static int[][] ar = new int[255][255];
	static boolean[][] visited = new boolean[255][255];

	static int D[] = new int[100005];

	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > m) {
			return false;
		}
		return true;
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Point(x, y));

		int size = 1;

		// duyet queue
		while (!queue.isEmpty()) {
			Point curPoint = queue.poll();

			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);

				if (isValid(newPoint) 
						&& visited[newPoint.x][newPoint.y] == false 
						&& ar[newPoint.x][newPoint.y] == 1) {
					
					visited[newPoint.x][newPoint.y] = true;
					size += 1;
					queue.add(newPoint);
				}
			}
		}
		D[size] += 1;
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		while (n > 0 && m > 0) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					ar[i][j] = sc.nextInt();
					visited[i][j] = false;
				}
			}

			for (int i = 1; i <= n * m; i++) {
				D[i] = 0;
			}
			
			
			
			/* -------- */
			for (int i = 1; i <= n * m; i++) {
				D[i] = 0;
			}
			
			int size = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (visited[i][j] == false && ar[i][j] == 1) {
						bfs(i, j);
						size += 1;
					}
				}
			}

			System.out.println(size);
			for (int i = 1; i <= n * m; i++) {
				if (D[i] > 0) {
					System.out.println(i + " " + D[i]);
				}
			}
			
			// ket thuc 1 test case
			n = sc.nextInt();
			m = sc.nextInt();
		}

		
	}

	/**
	 * @author kiet.nguyen
	 */

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
