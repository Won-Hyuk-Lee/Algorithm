import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("Case #").append(tc).append(": INSOMNIA\n");
                continue;
            }
            
            HashSet<Integer> hs = new HashSet<>();
            int cur = 0;
            while (hs.size() < 10) {
                cur += n;
                int tmp = cur;
                while (tmp > 0) {
                    hs.add(tmp % 10);
                    tmp /= 10;
                }
            }
            sb.append("Case #").append(tc).append(": ").append(cur).append('\n');
        }
        System.out.print(sb);
    }
}