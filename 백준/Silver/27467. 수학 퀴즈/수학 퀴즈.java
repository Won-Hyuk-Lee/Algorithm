import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int p = 0, q = 0;

        for (int num : numbers) {
            int mod = num % 3;
            if (mod == 0) {
                q++;
            } else if (mod == 1) {
                p++;
            } else {
                p--;
                q--;
            }
        }

        System.out.println(p + " " + q);
    }
}
