import java.io.*;
import java.util.*;

class Main {
    static int N, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(count);
    }

    static void dfs(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }
        if (dir != 1) {
            int ny = y + 1;
            if (ny < N && map[x][ny] == 0) dfs(x, ny, 0);
        }
        if (dir != 0) {
            int nx = x + 1;
            if (nx < N && map[nx][y] == 0) dfs(nx, y, 1);
        }
        int nx = x + 1, ny = y + 1;
        if (nx < N && ny < N && map[nx][ny] == 0 && map[x][ny] == 0 && map[nx][y] == 0)
            dfs(nx, ny, 2);
    }
}