import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        int k = Integer.parseInt(scan.next());
        String s = scan.next();

        int x = 0, y = 0, count = 0;
        for (int round = 0; round < k && count <= 5000000; round++) {
            for (int i = 0; i < n; i++) {
                char move = s.charAt(i);
                if (move == 'U') x++;
                else if (move == 'D') x--;
                else if (move == 'R') y++;
                else if (move == 'L') y--;

                count++;
                if (x == 0 && y == 0) {
                    System.out.print("YES");
                    return;
                }
            }
        }
        System.out.print("NO");
    }
}
