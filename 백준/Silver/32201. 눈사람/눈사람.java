import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int n = read();
        for (int i = 0; i < n; i++) map.put(read(), i);

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int k = read(), d = map.get(k) - i;
            if (d > max) {
                max = d;
                list.clear();
            }
            if (d == max) list.add(k);
        }

        for (int i : list) sb.append(i).append(" ");
        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
