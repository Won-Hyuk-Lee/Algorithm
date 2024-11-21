import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int seed = sc.nextInt();
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();

        for (int a = 0; a < m; a++) {
            for (int c = 0; c < m; c++) {
                if (x1 == (a * seed + c) % m && x2 == (a * x1 + c) % m) {
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }
    }
}
