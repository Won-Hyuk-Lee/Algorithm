import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Deque<Integer> dq = new ArrayDeque<>();
            String[] nums = s.substring(1, s.length() - 1).split(",");
            for (int i = 0; i < n; i++) dq.add(Integer.parseInt(nums[i]));
            boolean rev = false, err = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') rev = !rev;
                else if (dq.isEmpty()) { err = true; break; }
                else if (rev) dq.pollLast(); else dq.pollFirst();
            }
            if (err) System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder("[");
                while (!dq.isEmpty()) sb.append(rev ? dq.pollLast() : dq.pollFirst()).append(",");
                if (sb.length() > 1) sb.setLength(sb.length() - 1);
                System.out.println(sb.append("]"));
            }
        }
    }
}
