package self;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildARockery {
	static Scanner sc = new Scanner(System.in);
	static int a[][] = new int[22][22];
	static int n;
	static boolean[][] visited = new boolean[22][22];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	
	static int G[] = new int[11];
	static int totalMount;

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > n) {
			return false;
		}
		return true;
	}

	static void bfs(int x, int y, int height) {
		Point p = new Point(x, y);
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] > height) {
					visited[newPoint.x][newPoint.y] = true;
					q.add(newPoint);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		
		
		for (int height = 0; height <= 10; height++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					visited[i][j] = false;
				}
			}
			
			
			totalMount = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (visited[i][j] == false && a[i][j] > height) {
						bfs(i, j, height);
						totalMount++;
					}
				}
			}
			G[height] = totalMount;
		}
		
//		for (int i = 0; i <= 10; i++) {
//			System.out.println(i + " : " + G[i]);
//		}
		
		int result = 0;
		int max = G[0];
		
		for (int i = 1; i <= 10; i++) {
			if (G[i] > max) {
				max = G[i];
				result = i;
			}
		}
		
		System.out.println(result);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
