import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = Integer.parseInt(sc.nextLine());

        int software = 0, embedded = 0, ai = 0, noDept = 0;
        for (int i = 0; i < p; i++) {
            String[] input = sc.nextLine().split(" ");
            int grade = Integer.parseInt(input[0]);
            int classNum = Integer.parseInt(input[1]);

            if (grade == 1) noDept++;
            else if (classNum <= 2) software++;
            else if (classNum == 3) embedded++;
            else if (classNum == 4) ai++;
        }

        System.out.println(software);
        System.out.println(embedded);
        System.out.println(ai);
        System.out.println(noDept);
    }
}
