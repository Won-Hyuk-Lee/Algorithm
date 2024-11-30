import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String cur = br.readLine();
            int n = (cur.length() + 2) / 3;

            String curPrime = cur.substring(0, n);
            String revCurPrime = new StringBuilder(curPrime).reverse().toString();
            String tailRCP = revCurPrime.substring(1);
            String tailCP = curPrime.substring(1);

            String p1 = curPrime + revCurPrime + curPrime;
            String p2 = curPrime + tailRCP + curPrime;
            String p3 = curPrime + revCurPrime + tailCP;
            String p4 = curPrime + tailRCP + tailCP;

            if (cur.equals(p1) || cur.equals(p2) || cur.equals(p3) || cur.equals(p4)) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
