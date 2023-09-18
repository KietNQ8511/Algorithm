package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RGBImage {
	static int n, m;
	static Scanner sc = new Scanner(System.in);
	static char a[][] = new char[105][105];
	static boolean[][] visited = new boolean[105][105];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int size;
	static int block;
	static int[] result = new int[7];

	static boolean isValid(Point p) {
		if (p.x <= 0 || p.x > n || p.y <= 0 || p.y > m) {
			return false;
		}

		return true;
	}

	static void bfs(int x, int y, char c) {
		Point p = new Point(x, y);
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i <= 3; i++) {
				Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
				if (isValid(newPoint) && !visited[newPoint.x][newPoint.y] && a[newPoint.x][newPoint.y] == c) {
					size++;
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
				a[i][j] = tmpString.charAt(i);
			}
		}

		size = 0;
		block = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visited[i][j] == false && a[i][j] == 'G') {
					bfs(i, j, 'G');
					block++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				visited[i][j] = false;
			}
		}

		Result[] rs = new Result[4];

		rs[1] = new Result(block, size, 'G');

		size = 0;
		block = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visited[i][j] == false && a[i][j] == 'B') {
					bfs(i, j, 'B');
					block++;
				}
			}
		}

		rs[2] = new Result(block, size, 'B');
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				visited[i][j] = false;
			}
		}

		size = 0;
		block = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visited[i][j] == false && a[i][j] == 'R') {
					bfs(i, j, 'R');
					block++;
				}
			}
		}
		rs[3] = new Result(block, size, 'R');

		int output;

		for (int i = 1; i <= 3; i++) {
			System.out.println(rs[i].type + "\t" + rs[i].num + "\t" + rs[i].size);
		}

		int result = 1;
		if (rs[1].num > rs[2].num) {
			if (rs[2].num >= rs[3].num) {
				output = 1;
			} else if (rs[1].num > rs[3].num) {
				output = 1;
			} else if (rs[1].num == rs[3].num) {
				output = 13;
			} else {
				output = 3;
			}
		} else if (rs[1].num == rs[2].num) {
			if (rs[2].num > rs[3].num) {
				output = 12;
			} else if (rs[2].num == rs[3].num) {
				output = 123;
			} else {
				output = 3;
			}
		} else {
			if (rs[2].num > rs[3].num) {
				output = 2;
			} else if (rs[2].num == rs[3].num) {
				output = 23;
			} else {
				output = 3;
			}
		}

		if (output / 10 == 0) {
			if (output == 1) {
				System.out.println("G");
			} else if (output == 2) {
				System.out.println("B");
			} else {
				System.out.println("R");
			}
		} else if (output / 100 > 0) {
			if (rs[1].size > rs[2].size) {
				if (rs[2].size >= rs[3].size) {
					System.out.println("G");
				} else if (rs[1].size > rs[3].size) {
					System.out.println("G");
				} else {
					System.out.println("R");
				}
			} else if (rs[1].size == rs[2].size) {
				if (rs[2].size > rs[3].size) {
					System.out.println("B");
				} else {
					System.out.println("R");
				}
			} else if (rs[1].size < rs[2].size) {
				if (rs[1].size >= rs[3].size) {
					System.out.println("B");
				} else if (rs[2].size > rs[3].size) {
					System.out.println("B");
				} else {
					System.out.println("R");
				}
			}
		} else {
			if (output == 12) {
				if (rs[1].size >= rs[2].size) {
					System.out.println("G");
				} else {
					System.out.println("B");
				}
			} else if (output == 13) {
				if (rs[1].size > rs[3].size) {
					System.out.println("G");
				} else {
					System.out.println("R");
				}
			} else if (output == 23) {
				if (rs[2].size > rs[3].size) {
					System.out.println("B");
				} else {
					System.out.println("R");
				}
			}
		}

		// GBR

		// R > G > B

//		int blockResult = 2;
//		for (int i = 4; i <= 6; i++) {
//			if (blockResult < result[i]) {
//				blockResult = i;
//			} else if (blockResult == result[i]) {
//				blockResult = blockResult * 10 + i;
//			}
//		}
//
//		if (blockResult / 10 == 0) {
//			switch(blockResult) {
//				case 2: System.out.println('G');
//					break;
//				case 4: System.out.println('B');
//					break;
//				case 6: System.out.println('R');
//					break;
//			}
//		} else if (blockResult / 100 == 0) {
//			switch(blockResult) {
//			
//			case 24: 
//				if (result[1] > result[3]) {
//					System.out.println("G");
//				} else {
//					System.out.println("B");
//				}
//				break;
//			case 26: 
//				if (result[1] > result[3]) {
//					System.out.println("G");
//				} else {
//					System.out.println("B");
//				}
//				break;
//			case 46:
//				if (result[3] > result[5]) {
//					System.out.println("B");
//				} else {
//					System.out.println("R");
//				}
//				break;
//			}
//		} else {
//			if (result[1] > result[3]) {
//				if (result[3] <= result[5]) {
//					System.out.println("G");
//				} else if (result[1] > result[5]) {
//					System.out.println("G");
//				} else {
//					System.out.println("R");
//				}
//			} else if (result[3] > result[5]) {
//				System.out.println("B");
//			} else {
//				System.out.println("R");
//			}
//		}

		// 246
		// 24
		// 26
		// 46

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
	 */

	static class Result {
		int num, size;
		char type;

		public Result(int num, int size, char type) {
			// TODO Auto-generated constructor stub
			this.num = num;
			this.size = size;
			this.type = type;
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
