import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[i][j] = (r + g + b) / 3;
            }
        }
        
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = map[i][j] >= t ? 255 : 0;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 255 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 255 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}