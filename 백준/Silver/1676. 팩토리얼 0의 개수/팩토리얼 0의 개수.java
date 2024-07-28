import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;

        //5의 배수마다 5를 센다
        for (int i = 5; i <= N; i *= 5) {
            //N 이하의 i의 배수의 개수 count ++
            count += N / i;
        }

        System.out.println(count);
    }
}
