import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int r = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (r-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            boolean ok = true;
            for (int i = 0; i < cnt; i++) {
                int s = Integer.parseInt(st.nextToken());
                if (map.containsKey(s)) list.add(map.get(s));
                else {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                for (int id : list) sb.append(id).append(' ');
                sb.setLength(sb.length() - 1);
            } else sb.append("YOU DIED");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
