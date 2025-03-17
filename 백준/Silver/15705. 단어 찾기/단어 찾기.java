import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;
    static String word;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean searchWord() {
        int len = word.length();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == word.charAt(0)) {
                    for (int d = 0; d < 8; d++) {
                        int x = i, y = j;
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < len; k++) {
                            if (x < 0 || y < 0 || x >= N || y >= M) break;
                            sb.append(map[x][y]);
                            x += dx[d];
                            y += dy[d];
                        }
                        if (sb.toString().equals(word) || sb.reverse().toString().equals(word)) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
        System.out.println(searchWord() ? 1 : 0);
    }
}