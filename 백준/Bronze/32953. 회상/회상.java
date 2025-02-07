import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt(), m = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int num = in.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int cnt = 0;
        for (int v : map.values()) {
            if (v >= m) cnt++;
        }
        out.write(String.valueOf(cnt));
        out.flush();
    }
    
    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int pointer = 0, bytesRead = 0;
        
        private int read() throws IOException {
            if (pointer == bytesRead) {
                bytesRead = System.in.read(buffer, 0, BUFFER_SIZE);
                if (bytesRead == -1) return -1;
                pointer = 0;
            }
            return buffer[pointer++];
        }
        
        public int nextInt() throws IOException {
            int c;
            while ((c = read()) != -1 && isSpace(c));
            if (c == -1) return -1;
            boolean neg = c == '-';
            if (neg) c = read();
            int res = 0;
            do {
                res = res * 10 + (c - '0');
            } while ((c = read()) != -1 && !isSpace(c));
            return neg ? -res : res;
        }
        
        private boolean isSpace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t';
        }
    }
}
