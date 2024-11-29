import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        int score = 0;

        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            score += cnt[c - 'A'];
        }

        score %= 10;

        if (score % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }

        sc.close();
    }
}
