import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       StringTokenizer st = new StringTokenizer(br.readLine());
       long n = Long.parseLong(st.nextToken());
       long m = Long.parseLong(st.nextToken());
       
       bw.write(String.valueOf(n * (m - 1) + m * (n - 1) + 2 * (n - 1) * (m - 1)));
       bw.newLine();
       bw.flush();
       bw.close();
       br.close();
   }
}