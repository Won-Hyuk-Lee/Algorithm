import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            String s = Integer.toString(i);
            int slen = s.length();
            int idx = 0;

            while (idx < slen && s.charAt(idx) != '2') idx++;
            if (idx == slen) continue;
            while (idx < slen && s.charAt(idx) != '0') idx++;
            if (idx == slen) continue;
            while (idx < slen && s.charAt(idx) != '2') idx++;
            if (idx == slen) continue;
            while (idx < slen && s.charAt(idx) != '3') idx++;
            if (idx == slen) continue;

            ans++;
        }

        System.out.println(ans);
        sc.close();
    }
}
