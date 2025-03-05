import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(str1.length() >= str2.length() ? "go" : "no");
        }
    }
}
