import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int n = Integer.parseInt(br.readLine());
       int[] votes = new int[n];
       int cntKoo = 0;
       
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
           votes[i] = Integer.parseInt(st.nextToken());
           if (votes[i] == 1) {
               cntKoo++;
           }
       }
       
       if (cntKoo >= (n + 1) / 2) {
           bw.write("0\n");
           bw.flush();
           return;
       }
       
       int cntKooLeft = 0;
       int cntKooRight = 0;
       for (int i = 0; i < n; i++) {
           if (votes[i] == 1) {
               cntKooLeft++;
           }
           if (votes[n - 1 - i] == 1) {
               cntKooRight++;
           }
           if (cntKooLeft >= (i + 2) / 2 || cntKooRight >= (i + 2) / 2) {
               bw.write("1\n");
               bw.flush();
               return;
           }
       }
       
       bw.write("2\n");
       bw.flush();
   }
}