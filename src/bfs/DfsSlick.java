package bfs;

import java.util.Scanner;

public class DfsSlick {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int a[][] = new int[255][255];
	static boolean[][] visited = new boolean[255][255];
	static int size = 0;
	static int D[] = new int[100005];

	static boolean isValid(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	/**
	 * Dang visit o (i, j) input: visited, a output: visited da dc danh dau cac o
	 * loang tu (i, j)
	 */
	static void dfs(int i, int j) {

		// kiem tra dieu kien truoc khi tham
		if (isValid(i, j) == false || visited[i][j] == true || a[i][j] == 0)
			return;

		// bat dau tham
		visited[i][j] = true;
		size++;
		
		// tham o lien ke
		dfs(i + 1, j);
		dfs(i, j + 1);
		dfs(i - 1, j);
		dfs(i, j - 1);
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visited[i][j] == false && a[i][j] == 1) {
					size = 0;
					dfs(i, j);
					D[size] += 1;
					cnt++;
				}
			}
		}

		System.out.println(cnt);

		for (int i = 1; i <= n * m; i++) {
			if (D[i] > 0) {
				System.out.println(i + " " + D[i]);
			}
		}
	}
}
