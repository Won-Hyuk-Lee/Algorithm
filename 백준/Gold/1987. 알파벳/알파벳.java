import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max;
    static char[][] board;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();

        alpha[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            int idx = board[nx][ny] - 'A';
            if (!alpha[idx]) {
                alpha[idx] = true;
                dfs(nx, ny, count + 1);
                alpha[idx] = false;
            }
        }
    }
}
