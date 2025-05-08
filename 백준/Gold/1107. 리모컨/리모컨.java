import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) broken[Integer.parseInt(st.nextToken())] = true;
        }
        int min = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean valid = true;
            for (char c : s.toCharArray())
                if (broken[c - '0']) {
                    valid = false;
                    break;
                }
            if (valid) min = Math.min(min, s.length() + Math.abs(target - i));
        }
        System.out.println(min);
    }
}
