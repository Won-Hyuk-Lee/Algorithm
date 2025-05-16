import java.util.*;

public class Main {
    static int M, N;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[x][y] > map[nx][ny])
                dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }
}
