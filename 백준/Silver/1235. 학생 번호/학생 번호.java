import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        var set = new HashSet<String>();

        var input = new String[N];
        for (int i = 0; i < N; i++) input[i] = in.readLine();
        int len = input[0].length();

        for (int k = 1; k <= len; k++) {
            for (var s : input) {
                set.add(s.substring(len - k));
            }
            if (set.size() == N) {
                System.out.println(k);
                return;
            }
            set.clear();
        }
    }
}
