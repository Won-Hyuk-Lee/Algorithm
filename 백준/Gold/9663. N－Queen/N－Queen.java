import java.io.*;

public class Main {
    static int N, count;
    static int[] col;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        col = new int[N];
        dfs(0);
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (check(row)) dfs(row + 1);
        }
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row] || Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}
