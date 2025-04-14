import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] map, visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int operations = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, ++operations);
                }
            }
        }

        System.out.println(operations);
    }

    private static void bfs(int x, int y, int mark) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = mark;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int cur = map[p.x][p.y];

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d], ny = p.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0
                        && Math.abs(cur - map[nx][ny]) <= k) {
                    visited[nx][ny] = mark;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}
