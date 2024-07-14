import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        int[] list = new int[6];
        
        for (int i = 0; i < 6; i++) {
            list[i] = sc.nextInt();
        }
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int t = 0; //총합
        
        for (int i = 0; i < 6; i++) {
            //a로 나눈 몫 + t
            t += list[i] / a;
            
            //a로 나눈 나머지가 0이 아닌 경우
            if (list[i] % a != 0) {
                t++;
            }
        }
        System.out.println(t);
        //num을 b로 나눈 몫과 나머지
        System.out.println(num / b + " " + num % b);
        sc.close();
    }
}
