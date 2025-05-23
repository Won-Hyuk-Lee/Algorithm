import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (N == 3) {
            System.out.println((R == 2 && C == 2) ? 1 : 4);
        } else if (N % 2 == 1) {
            System.out.println(((R + C) % 2 == 1) ? (N * N) / 2 : (N * N) / 2 + 1);
        } else {
            System.out.println((N * N) / 2);
        }
    }
}
