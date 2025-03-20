import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());

        if (X > Y) {
            int tempX = X, tempP1 = P1;
            X = Y;
            P1 = P2;
            Y = tempX;
            P2 = tempP1;
        }

        int cnt = 0;
        while (P1 + cnt * X <= 10000 + P1) {
            int num = P1 + cnt * X - P2;
            if (num >= 0 && num % Y == 0) {
                System.out.println(P1 + cnt * X);
                return;
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
