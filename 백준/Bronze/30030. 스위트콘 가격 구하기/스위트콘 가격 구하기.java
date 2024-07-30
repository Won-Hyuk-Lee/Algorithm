import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner 스캐너 = new Scanner(System.in);

        int 부가가치세포함가격 = 스캐너.nextInt();
        int 부가가치세제외가격 = (int)(부가가치세포함가격*10/11);

        System.out.println(부가가치세제외가격);

        스캐너.close();
    }
}
