import java.util.*;

public class Main {
    static String[] res = new String[70];

    static {
        res[11] = "23 * 89 = 2047 = ( 2 ^ 11 ) - 1";
        res[23] = "47 * 178481 = 8388607 = ( 2 ^ 23 ) - 1";
        res[29] = "233 * 1103 * 2089 = 536870911 = ( 2 ^ 29 ) - 1";
        res[37] = "223 * 616318177 = 137438953471 = ( 2 ^ 37 ) - 1";
        res[41] = "13367 * 164511353 = 2199023255551 = ( 2 ^ 41 ) - 1";
        res[43] = "431 * 9719 * 2099863 = 8796093022207 = ( 2 ^ 43 ) - 1";
        res[47] = "2351 * 4513 * 13264529 = 140737488355327 = ( 2 ^ 47 ) - 1";
        res[53] = "6361 * 69431 * 20394401 = 9007199254740991 = ( 2 ^ 53 ) - 1";
        res[59] = "179951 * 3203431780337 = 576460752303423487 = ( 2 ^ 59 ) - 1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            if (res[i] != null) {
                System.out.println(res[i]);
            }
        }
    }
}
