package part2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Slick2 {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int a[][] = new int[255][255];
	static boolean[][] visited = new boolean[255][255];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[] G = new int[100005];
	
	static boolean isValid(Point p) {
		if (p.x > 0 && p.x <= n && p.y > 0 && p.y <= m) {
			return true;
		}
		
		return false;
	}
	
	static void bfs(int x, int y, int level) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] > level) {
					q.add(newPoint);
					visited[newPoint.x][newPoint.y] = true;
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
		
		
		for (int level = 1; level <= 1000; level++) {
			// reset data
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					visited[i][j] = false;
				}
			}
			
			// tim kiem thanh phan lien thong cac o > level
			int cnt = 0;
			
			for (int i = 1; i <= n; i++ ) {
				for (int j = 1; j <= m; j++) {
					if (visited[i][j] == false && a[i][j] > level) {
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
		
		System.out.println(-1);
	}
	
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
