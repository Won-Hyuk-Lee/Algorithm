import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int distance = sc.nextInt();
        
        int time = (distance + 4) / 5;
        
        System.out.println(time);
    }
}