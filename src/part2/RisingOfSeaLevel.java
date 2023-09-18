package part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RisingOfSeaLevel {
	static Scanner sc = new Scanner(System.in);
	static char[][] a = new char[255][255];
	static boolean[][] visited = new boolean[255][255];
	static int n, m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int x1, x2, y1, y2;
	static int dist[][] = new int[105][105];
	static int oo = 1000000000;
	static int[][] minPath = new int[15][15];
	static int[] G = new int[15];
	static boolean checkG[] = new boolean[15];
	
	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > m) {
			return false;
		}
		return true;
	}

	static void gen(int i, int n) {
		for (int j = 1; j <= n; j++) {
			if (checkG[j] == true) continue;
			G[i] = j;
			checkG[j] = true;
			if (i == n) {
				for (int k = 1; k <= n; k++) {
					System.out.print(G[k]);
				}
				System.out.println();
			}
			else gen(i + 1, n);
			checkG[j] = false;
		}
	}
	
	// input: x1, y1, a, visited
	// output:
	static void bfs(int x, int y) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dist[i][j] = oo;
				visited[i][j] = false;
			}
		}

		dist[x][y] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] != '+') {
					dist[newPoint.x][newPoint.y] = dist[curPoint.x][curPoint.y] + 1;
					visited[newPoint.x][newPoint.y] = true;
					q.add(newPoint);
				}

			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i][j] != '+' && a[i][j] != '-') {
					//i, j, x, y
					if (dist[i][j] != oo) {
						minPath[a[x][y] - '0'][a[i][j] - '0'] = dist[i][j];
					}
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

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (a[i][j] != '-' && a[i][j] != '-') {
//					bfs(i, j); 
//					
//					for (int x = 1; x <= n; x++) {
//						for (int y = 1; y <= m; y++) {
//							if (a[x][y] != '+' && a[i][j] != '-') {
//								//i, j, x, y
//								minPath[a[i][j] - '0'][a[x][y] - '0'] = dist[x][y];
//							}
//						}
//					}
//					
//				}
//			}
//		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i][j] != '+' && a[i][j] != '-') {
					bfs(i, j);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				sum += minPath[i][j];
			}
		}
		
		System.out.println(sum);

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
