import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        //최대공약수(GCD)
        int gcd = gcd(a, b);
        //최소공배수(LCM)
        int lcm = a * b / gcd;
        
        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    //유클리드 호제법을 사용한 GCD계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
