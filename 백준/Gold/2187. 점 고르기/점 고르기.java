import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] X = new int[N];
        int[] Y = new int[N];
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Math.abs(X[i] - X[j]) < A && Math.abs(Y[i] - Y[j]) < B) {
                    ans = Math.max(ans, Math.abs(C[i] - C[j]));
                }
            }
        }

        System.out.println(ans);
    }
}
