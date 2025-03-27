import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (n == 0) {
            System.out.println("NO");
            return;
        }

        while (n > 0) {
            if (n % 3 == 2) {
                System.out.println("NO");
                return;
            }
            n /= 3;
        }

        System.out.println("YES");
    }
}
