import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IceBerg {
    int x, y;
    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int cnt = countIcebergs();
            if (cnt >= 2) break;
            if (cnt == 0) {
                year = 0;
                break;
            }
            melt();
            year++;
        }

        System.out.println(year);
    }

    static int countIcebergs() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }

    static void melt() {
        int[][] temp = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] > 0) {
                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            sea++;
                        }
                    }
                    temp[x][y] = Math.max(0, map[x][y] - sea);
                }
            }
        }
        map = temp;
    }
}
