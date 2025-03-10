import java.io.*;
import java.util.*;

public class Main {
    static String xA, xB, x, max;
    static long a, b;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        xA = s[0];
        xB = s[1];
        max = String.valueOf((long) Math.pow(2, 63));

        arr = new int[200];
        for (int i = 0; i < 9; i++) arr[i + '1'] = i + 1;
        for (int i = 0; i < 26; i++) arr['a' + i] = i + 10;

        solve();

        if (count == 0) {
            System.out.println("Impossible");
        } else if (count == 1) {
            System.out.println(x + " " + a + " " + b);
        } else {
            System.out.println("Multiple");
        }
    }

    public static void solve() {
        for (int i = 1; i <= 36; i++) {
            for (int j = 1; j <= 36; j++) {
                if (i == j) continue;
                if (check(i, xA) && check(j, xB)) {
                    String valA = find(i, xA);
                    String valB = find(j, xB);
                    if (valA.equals(valB) && valA.compareTo(max) < 0) {
                        count++;
                        x = valA;
                        a = i;
                        b = j;
                    }
                }
            }
        }
    }

    public static String find(int base, String s) {
        long result = 0;
        for (char c : s.toCharArray()) {
            result = result * base + arr[c];
        }
        return String.valueOf(result);
    }

    public static boolean check(int base, String s) {
        for (char c : s.toCharArray()) {
            if (base <= arr[c]) return false;
        }
        return true;
    }
}