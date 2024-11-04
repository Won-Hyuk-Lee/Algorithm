import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 1; i < N; i++) {
            String a = input.substring(0, i);
            String b = input.substring(N - i, N);

            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    if (1 < ++cnt) break;
                }
            }

            if (cnt == 1) {
                System.out.print("YES");
                return;
            }
        }

        System.out.print("NO");

    }
	
}