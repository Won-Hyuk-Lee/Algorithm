import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), C = sc.nextInt();
        int a = N, b = N;
        while (C-- > 0) {
            int y = sc.nextInt(), x = sc.nextInt();
            if (x <= a && y <= b) {
                if (x * b > y * a) a = x;
                else b = y;
            }
        }
        System.out.println(a * b);
    }
}
