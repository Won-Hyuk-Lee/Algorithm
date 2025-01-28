import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int Q = Integer.parseInt(firstLine[2]);

        boolean[][] lawn = new boolean[N][M];
        int total = N * M;

        for (int i = 0; i < Q; i++) {
            String[] query = reader.readLine().split(" ");
            int type = Integer.parseInt(query[0]);

            if (type == 1) {
                int dy = Integer.parseInt(query[1]);
                int dx = Integer.parseInt(query[2]);
                int y = Integer.parseInt(query[3]) - 1;
                int x = Integer.parseInt(query[4]) - 1;

                while (y >= 0 && y < N && x >= 0 && x < M) {
                    if (lawn[y][x]) break;
                    lawn[y][x] = true;
                    total--;
                    y += dy;
                    x += dx;
                }
            } else if (type == 2) {
                int y = Integer.parseInt(query[1]) - 1;
                int x = Integer.parseInt(query[2]) - 1;
                System.out.println(lawn[y][x] ? 1 : 0);
            } else if (type == 3) {
                System.out.println(total);
            }
        }
    }
}
