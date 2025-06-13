import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String idx = st.nextToken();
            String originNum = st.nextToken();
            int origin = Integer.parseInt(originNum);

            if (origin == 1 || !isPrime(origin)) {
                System.out.println(idx + " " + originNum + " NO");
                continue;
            }

            ArrayList<Integer> seen = new ArrayList<>();
            int num = origin;

            while (true) {
                int sum = 0;
                while (num > 0) {
                    int digit = num % 10;
                    sum += digit * digit;
                    num /= 10;
                }

                if (sum == 1) {
                    System.out.println(idx + " " + originNum + " YES");
                    break;
                }

                if (seen.contains(sum)) {
                    System.out.println(idx + " " + originNum + " NO");
                    break;
                }

                seen.add(sum);
                num = sum;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
