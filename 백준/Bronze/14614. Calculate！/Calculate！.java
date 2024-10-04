import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        String c = sc.next();

        //XOR는 2번하면 돌아옴
        if ((c.charAt(c.length() - 1) - '0') % 2 == 0) {
            System.out.println(a);
        } else {
            int ans = a ^ b;
            System.out.println(ans);
        }

        sc.close();
    }
}
