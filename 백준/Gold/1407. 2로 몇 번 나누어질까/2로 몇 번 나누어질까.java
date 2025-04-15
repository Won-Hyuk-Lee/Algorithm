import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(total(B) - total(A - 1));
    }

    public static long total(long n) {
        if (n <= 0) return 0;
        
        long result = 0;
        long power = 1;
        
        while (n > 0) {
            result += (n / 2 + (n % 2)) * power;
            power *= 2;
            n /= 2;
        }
        
        return result;
    }
}