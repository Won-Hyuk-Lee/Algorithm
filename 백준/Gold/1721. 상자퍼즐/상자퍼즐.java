import java.util.*;

public class Main {
    static int n;
    static int[][] box = new int[26][4];
    static int[][] puzzle = new int[6][6];
    static int[][] rot = new int[6][6];
    static boolean[] vis = new boolean[26];
    static boolean isSolved = false;

    static void solve(int x, int y) {
        if (x > n) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(puzzle[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(rot[i][j] + " ");
                }
                System.out.println();
            }
            isSolved = true;
            return;
        }

        int[] match = new int[]{-1, -1, -1, -1};
        if (x == 1) match[0] = 0;
        else {
            int prevRot = rot[x - 1][y];
            match[0] = (2 - prevRot >= 0) ? box[puzzle[x - 1][y]][2 - prevRot] : box[puzzle[x - 1][y]][6 - prevRot];
        }
        if (y == 1) match[3] = 0;
        else {
            int prevRot = rot[x][y - 1];
            match[3] = (1 - prevRot >= 0) ? box[puzzle[x][y - 1]][1 - prevRot] : box[puzzle[x][y - 1]][5 - prevRot];
        }
        if (x == n) match[2] = 0;
        if (y == n) match[1] = 0;

        for (int idx = 1; idx <= n * n; idx++) {
            if (vis[idx]) continue;

            for (int r = 0; r < 4; r++) {
                boolean isMatch = true;
                for (int i = 0; i < 4; i++) {
                    if (match[i] == -1) continue;
                    int checkIdx = (i >= r) ? i - r : 4 + i - r;
                    if (match[i] != box[idx][checkIdx]) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    puzzle[x][y] = idx;
                    rot[x][y] = r;
                    vis[idx] = true;

                    if (y == n) solve(x + 1, 1);
                    else solve(x, y + 1);

                    vis[idx] = false;

                    if (isSolved) return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n * n; i++) {
            int u = sc.nextInt();
            box[u][0] = sc.nextInt();
            box[u][1] = sc.nextInt();
            box[u][2] = sc.nextInt();
            box[u][3] = sc.nextInt();
        }
        solve(1, 1);
    }
}
