import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ans = true;
        int N = sc.nextInt();
        int NN = N * N;
        int[][] arr = new int[N][N];
        HashSet<Integer> visited = new HashSet<>();
        int linesum = NN * (NN + 1) / (2 * N);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int x = sc.nextInt();
                if (!visited.add(x)) ans = false;
                arr[r][c] = x;
            }
        }

        for (int r = 0; r < N; r++) {
            int rsum = 0;
            for (int c = 0; c < N; c++) {
                rsum += arr[r][c];
            }
            if (rsum != linesum) ans = false;
        }

        for (int c = 0; c < N; c++) {
            int csum = 0;
            for (int r = 0; r < N; r++) {
                csum += arr[r][c];
            }
            if (csum != linesum) ans = false;
        }

        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < N; i++) {
            diag1 += arr[i][i];
            diag2 += arr[i][N - i - 1];
        }

        if (diag1 != linesum || diag2 != linesum) ans = false;

        System.out.println(ans ? "TRUE" : "FALSE");
    }
}
