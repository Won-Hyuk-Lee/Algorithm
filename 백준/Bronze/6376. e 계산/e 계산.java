import java.text.DecimalFormat;

public class Main {

    public static double fac(int n) {
        double f = 1.0;
        for (double i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static void main(String[] args) {
        double ans = 1.0;

        DecimalFormat df = new DecimalFormat("0.000000000");

        System.out.println("n e");
        System.out.println("- -----------");
        System.out.println("0 1");

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " ");
            ans += 1 / fac(i);

            if (i == 1) {
                System.out.println(2);  //정수
            } else if (i == 2) {
                System.out.println("2.5");  //2.5
            } else {
                System.out.println(df.format(ans));  //소수점 9자리
            }
        }
    }
}
