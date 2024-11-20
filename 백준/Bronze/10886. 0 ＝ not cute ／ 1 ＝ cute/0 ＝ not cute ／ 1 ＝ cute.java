import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int cuteCount = 0;
        int notCuteCount = 0;

        for (int i = 0; i < testCase; i++) {
            if (sc.nextInt() == 1) {
                cuteCount++;
            } else {
                notCuteCount++;
            }
        }

        if (cuteCount > notCuteCount) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}
