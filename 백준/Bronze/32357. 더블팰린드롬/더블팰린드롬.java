import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            boolean isPal = true;
            for (int a = 0, b = t.length() - 1; a < b; a++, b--) {
                if (t.charAt(a) != t.charAt(b)) {
                    isPal = false;
                    break;
                }
            }
            if (isPal) {
                cnt++;
            }
        }
        System.out.println(cnt * (cnt - 1));
    }
}
