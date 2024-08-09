import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String A = scanner.next();
        String P = scanner.next();
        
        //B=P일때 그냥 만족하니까 바로 출력
        System.out.println(P);
        
        scanner.close();
    }
}
