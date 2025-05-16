import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int R, C, N;
    static char[][] map;
    static int[][] bombTime;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rcnt = br.readLine().split(" ");
        R = Integer.parseInt(rcnt[0]);
        C = Integer.parseInt(rcnt[1]);
        N = Integer.parseInt(rcnt[2]);

        map = new char[R][C];
        bombTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') bombTime[i][j] = 3;
            }
        }

        int time = 1;
        while (time < N) {
            time++;
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            } else {
                boolean[][] explode = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombTime[i][j] == time) {
                            explode[i][j] = true;
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];
                                if (ni >= 0 && nj >= 0 && ni < R && nj < C) {
                                    if (bombTime[ni][nj] != time) explode[ni][nj] = true;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (explode[i][j]) {
                            map[i][j] = '.';
                            bombTime[i][j] = 0;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }
}
