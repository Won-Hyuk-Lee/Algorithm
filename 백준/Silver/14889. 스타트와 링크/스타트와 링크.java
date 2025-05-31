import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visit;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = in.nextInt();
            }
        }

        combi(0, 0);
        System.out.println(Min);
    }

    static void combi(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    teamStart += map[i][j] + map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    teamLink += map[i][j] + map[j][i];
                }
            }
        }

        int val = Math.abs(teamStart - teamLink);
        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        Min = Math.min(Min, val);
    }
}
