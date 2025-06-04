import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int count = Integer.parseInt(br.readLine());
       
       for (int i = 0; i < count; i++) {
           String[] input = br.readLine().split(" ");
           int candyCount = Integer.parseInt(input[0]);
           int boxCount = Integer.parseInt(input[1]);
           
           Integer[] boxes = new Integer[boxCount];
           for (int j = 0; j < boxCount; j++) {
               input = br.readLine().split(" ");
               boxes[j] = Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
           }
           
           Arrays.sort(boxes, Collections.reverseOrder());
           
           int result = 0;
           for (int box : boxes) {
               candyCount -= box;
               result++;
               if (candyCount <= 0) break;
           }
           
           bw.write(result + "\n");
       }
       
       bw.flush();
       bw.close();
       br.close();
   }
}