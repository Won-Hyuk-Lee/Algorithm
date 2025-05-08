import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- > 0) {
                String[] cmd = br.readLine().split(" ");
                int num = Integer.parseInt(cmd[1]);
                if (cmd[0].equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int key = cmd[1].equals("1") ? map.lastKey() : map.firstKey();
                    if (map.put(key, map.get(key) - 1) == 1) map.remove(key);
                }
            }
            System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}
