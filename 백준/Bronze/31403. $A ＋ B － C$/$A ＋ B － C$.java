import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        
        //문자열 A, B결합
        String AB = A + B;
        
        //AB-C
        int result = Integer.parseInt(AB) - Integer.parseInt(C);
        //A+B-C
        int result2 = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
        
        System.out.println(result2);
        System.out.println(result);
    }
}
