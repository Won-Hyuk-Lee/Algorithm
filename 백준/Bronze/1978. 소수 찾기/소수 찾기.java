import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int res = 0;  //소수갯수
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();  //입력받은 숫자

            //a가 1이면 소수x
            if (a == 1) {
                continue;
            }

            boolean isPrime = true;
            for (int j = 2; j * j <= a; j++) {
                if (a % j == 0) {
                    isPrime = false;  //약수가 존재하면 소수x
                    break;
                }
            }

            //isPrime이 true면 소수
            if (isPrime) {
                res++;
            }
        }
        System.out.println(res);
    }
}
