import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int L = sc.nextInt();
        
        //공간에 최대 배치 수
        int maxCow = (W/L) * (H/L);
        
        //공간이 남는다고 없는애를 만들순 없으니 N이하의 값
        System.out.println(Math.min(N, maxCow));
    }
}