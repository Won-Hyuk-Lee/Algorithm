import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Math.abs(Integer.parseInt(st.nextToken()));
        int b = Math.abs(Integer.parseInt(st.nextToken()));
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println((a + b <= c && (a + b) % 2 == c % 2) ? "YES" : "NO");
    }
}