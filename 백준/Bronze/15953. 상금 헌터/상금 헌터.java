import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        int[] first = {500, 300, 300, 200, 200, 200, 50, 50, 50, 50,
                       30, 30, 30, 30, 30, 10, 10, 10, 10, 10, 10};
        int[] second = {512, 256, 256, 128, 128, 128, 128,
                        64, 64, 64, 64, 64, 64, 64, 64,
                        32, 32, 32, 32, 32, 32, 32, 32,
                        32, 32, 32, 32, 32, 32, 32, 32};

        while (T-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int money = 0;

            if (a > 0 && a <= 21) money += first[a - 1];
            if (b > 0 && b <= 31) money += second[b - 1];

            System.out.println(money * 10000);
        }

        scan.close();
    }
}
