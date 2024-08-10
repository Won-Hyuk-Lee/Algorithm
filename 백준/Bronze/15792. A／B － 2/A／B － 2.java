import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        sb.append(A/B+".");
        A = 10 * (A - B *(A/B));
        int T = 1500;
        while (T-- > 0) {
            sb.append(A/B+"");
            A = 10 * (A - B *(A/B));
        }
        System.out.println(sb.toString());
    }
 
}