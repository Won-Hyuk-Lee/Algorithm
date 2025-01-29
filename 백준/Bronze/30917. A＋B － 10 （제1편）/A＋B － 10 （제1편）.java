import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        while (true) {
            System.out.println("? A " + a);
            int resp = sc.nextInt();
            if (resp == 1) break;
            a++;
        }

        int b = 1;
        while (true) {
            System.out.println("? B " + b);
            int resp = sc.nextInt();
            if (resp == 1) break;
            b++;
        }

        System.out.println("! " + (a + b));
    }
}
