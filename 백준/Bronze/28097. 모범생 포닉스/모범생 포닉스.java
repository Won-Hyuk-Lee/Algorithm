import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int totalMinutes = (N - 1) * 8; //쉬는 시간

        for (int i = 0; i < N; i++) {
            totalMinutes += sc.nextInt(); //문제를 푸는 데 걸리는 시간+
        }

        System.out.println((totalMinutes / 24) + " " + (totalMinutes % 24));

        sc.close();
    }
}
