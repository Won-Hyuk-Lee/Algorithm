import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, K, W;
        double P;
        N = sc.nextInt();
        K = sc.nextInt();
        P = sc.nextDouble();
        W = sc.nextInt();

        int cnt = (int) Math.ceil(P / W);
        System.out.println(cnt);

        sc.close();
    }
}
