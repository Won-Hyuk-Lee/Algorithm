import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();
        while (n-- > 0) {
            read();
            read();
        }

        int r = 0, g = 0, b = 0;
        while (m-- > 0) {
            read();
            read();

            char c = (char) System.in.read();
            if (c == 'R') r++;
            else if (c == 'B') b++;
            else g++;
        }

        bw.write(r + (g & 1) > b ? "jhnah917" : "jhnan917");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }
}
