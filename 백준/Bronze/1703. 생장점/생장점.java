import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            int tree = 1;
            for (int i = 0; i < N; i++) {
                int branches = Integer.parseInt(st.nextToken());
                int pruned = Integer.parseInt(st.nextToken());
                tree = tree * branches - pruned;
            }
            System.out.println(tree);
        }
    }
}
