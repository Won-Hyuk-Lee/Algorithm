import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] brandCount = new int[51];
        for (int i = 0; i < N; i++) {
            int brand = sc.nextInt();
            brandCount[brand]++;
        }
        long totalWays = 0;
        for (int K = 1; K <= 50; K++) {
            long ways = 1;
            for (int b = 1; b <= K; b++) {
                ways *= brandCount[b];
            }
            totalWays += ways;
        }
        System.out.println(totalWays);
    }
}
