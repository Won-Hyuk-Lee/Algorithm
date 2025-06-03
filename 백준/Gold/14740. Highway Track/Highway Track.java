import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       long[] a = new long[N + 1];
       long[] b = new long[N + 1];
       long[] c = new long[N + 1];
       long[] p = new long[N + 1];
       
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 1; i <= N; i++) {
           a[i] = Long.parseLong(st.nextToken());
       }
       
       st = new StringTokenizer(br.readLine());
       for (int i = 1; i <= N; i++) {
           b[i] = Long.parseLong(st.nextToken());
           c[i] = a[i] - b[i];
       }
       
       long tmp = 10000000L;
       for (int i = 1; i <= N; i++) {
           p[i] = p[i - 1] + c[i];
           tmp = Math.min(tmp, p[i]);
       }
       
       int ans = 0;
       for (int i = 1; i <= N; i++) {
           if (tmp == p[i]) {
               ans++;
           }
       }
       
       System.out.println(ans);
   }
}