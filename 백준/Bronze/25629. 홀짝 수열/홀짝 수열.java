import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        
        int a = 0; //홀수
        int b = 0; //짝수
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                a++;
            } else {
                b++;
            }
        }
        
        if (a == Math.ceil((double)N / 2) && b == N / 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
