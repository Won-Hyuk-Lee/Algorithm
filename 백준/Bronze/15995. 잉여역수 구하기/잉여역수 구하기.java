import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(calc(read(), read())));
        bw.flush();
    }

    private static int calc(int a, int m) {
        int x = 0;
        while (x++ < 10001) if (a * x % m == 1) return x;

        return x;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}