import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int go = scanner.nextInt();
            ans += Math.min(
                Math.abs(start - go),
                Math.min(360 - start + go, start + 360 - go)
            );
            start = go;
        }

        System.out.println(ans);

        scanner.close();
    }
}
