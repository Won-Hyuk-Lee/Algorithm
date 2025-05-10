import java.io.*;
import java.util.*;

public class Main {
    static class UnsafeScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public UnsafeScanner(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        public String next() {
            while (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        UnsafeScanner scan = new UnsafeScanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long w = scan.nextLong();
        scan.nextLong(); // Ignoring second input parameter (as in original code)
        
        int n = scan.nextInt();
        long d = scan.nextLong();
        
        long[] lanes = new long[n + 1];
        long[] densities = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            lanes[i] = scan.nextLong();
        }
        
        for (int i = 1; i <= n; i++) {
            densities[i] = scan.nextLong();
        }
        
        long val = 0;
        long ret = Long.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (lanes[i] >= d) {
                ret = Math.min(ret, val + (Math.max(lanes[i - 1], d) - lanes[i - 1] + w) * densities[i]);
                val += (lanes[i] - Math.max(lanes[i - 1], d)) * densities[i];
            }
            val += (lanes[i] - lanes[i - 1]) * densities[i];
        }
        
        out.write(String.valueOf(ret));
        out.newLine();
        out.flush();
    }
}