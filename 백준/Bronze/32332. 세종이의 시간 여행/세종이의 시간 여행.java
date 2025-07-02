import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int current_y = sc.nextInt();
        int current_m = sc.nextInt();
        int current_d = sc.nextInt();
        double current_latitude = sc.nextDouble();
        double current_hardness = sc.nextDouble();

        int moving_y = sc.nextInt();
        int moving_m = sc.nextInt();
        int moving_d = sc.nextInt();
        double moving_latitude = sc.nextDouble();
        double moving_hardness = sc.nextDouble();

        int real_y = 2 * current_y - moving_y;
        int real_m = 2 * current_m - moving_m;
        int real_d = 2 * current_d - moving_d;
        double real_latitude = 2 * current_latitude - moving_latitude;
        double real_hardness = 2 * current_hardness - moving_hardness;

        if (real_d <= 0) {
            real_d += 30;
            real_m--;
        } else if (real_d > 30) {
            real_d -= 30;
            real_m++;
        }

        if (real_m <= 0) {
            real_m += 12;
            real_y--;
        } else if (real_m > 12) {
            real_m -= 12;
            real_y++;
        }

        System.out.printf("%d %d %d ", real_y, real_m, real_d);
        System.out.printf("%.3f %.3f", real_latitude, real_hardness);
    }
}
