import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        System.out.println(exponentialCalculator(A, B, C));
    }

    //지수계산 메서드
    static long exponentialCalculator(int A, int B, int C) {
        if (B == 0)
            return 1;  //지수가 0이면 1

        long half = exponentialCalculator(A, B / 2, C);  //지수가 짝수면 반으로 나눈다.
        half = (half * half) % C;  //ex)_ 2의 10승은 2의 5승 * 2의 5승과 같다.

        if (B % 2 != 0)  //지수가 홀수면
            half = (half * A) % C;

        return half;
    }
}
