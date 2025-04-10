import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // f(digit) 매핑 배열
        int[] f = new int[10];
        int[] fInv = new int[10]; // 역함수

        String[] mapping = br.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            f[i] = Integer.parseInt(mapping[i]);
            fInv[f[i]] = i;
        }

        // f(A), f(B) 입력
        String[] ab = br.readLine().split(" ");
        String fa = ab[0];
        String fb = ab[1];

        StringBuilder aOrig = new StringBuilder();
        StringBuilder bOrig = new StringBuilder();

        for (char c : fa.toCharArray()) {
            aOrig.append(fInv[c - '0']);
        }
        for (char c : fb.toCharArray()) {
            bOrig.append(fInv[c - '0']);
        }

        long a = Long.parseLong(aOrig.toString());
        long b = Long.parseLong(bOrig.toString());
        long sum = a + b;

        StringBuilder result = new StringBuilder();
        for (char c : String.valueOf(sum).toCharArray()) {
            result.append(f[c - '0']);
        }

        bw.write(result.toString());
        bw.newLine();
        bw.flush();
    }
}
