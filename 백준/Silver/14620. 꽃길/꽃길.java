import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int count, int sum) {
        if (count == 3) {
            result = Math.min(result, sum);
            return;
        }
        
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (!visit[i][j] && isValid(i, j)) {
                    visit[i][j] = true;
                    int cost = plantCost(i, j);
                    dfs(count + 1, sum + cost);
                    clearVisit(i, j);
                    visit[i][j] = false;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visit[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private static int plantCost(int x, int y) {
        int cost = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visit[nx][ny] = true;
            cost += map[nx][ny];
        }
        return cost;
    }

    private static void clearVisit(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visit[nx][ny] = false;
        }
    }
}
