import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int left = X - R;
        int right = X + R;

        int A = 0;
        int B = 0;

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine().trim());
            if (v == left || v == right) {
                B++;
            } else if (v > left && v < right) {
                A++;
            }
        }

        System.out.println(A + " " + B);
    }
}
