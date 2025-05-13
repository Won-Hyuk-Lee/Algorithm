import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map, blindMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        blindMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                blindMap[i][j] = (c == 'G') ? 'R' : c;
            }
        }

        visited = new boolean[N][N];
        int normal = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    dfs(map, i, j, map[i][j]);
                    normal++;
                }

        visited = new boolean[N][N];
        int blind = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    dfs(blindMap, i, j, blindMap[i][j]);
                    blind++;
                }

        System.out.println(normal + " " + blind);
    }

    static void dfs(char[][] board, int x, int y, char color) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!visited[nx][ny] && board[nx][ny] == color)
                dfs(board, nx, ny, color);
        }
    }
}
