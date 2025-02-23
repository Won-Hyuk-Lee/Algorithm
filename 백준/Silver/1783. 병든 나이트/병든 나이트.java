import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int ans = (n == 1) ? 1 : (n == 2) ? Math.min(4, (m + 1) / 2) : (m >= 7) ? m - 2 : Math.min(4, m);
        
        System.out.println(ans);
    }
}