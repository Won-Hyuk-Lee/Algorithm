import java.util.*;
import java.io.*;

public class Main {
   static int n = 0;
   static int[][] board;
   static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
   static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       n = Integer.parseInt(br.readLine());
       board = new int[n + 1][n + 1];
       
       for (int i = 1; i <= n; i++) {
           String line = br.readLine();
           for (int j = 1; j <= n; j++) {
               char c = line.charAt(j - 1);
               board[i][j] = (c == '#') ? 9 : c - '0';
           }
       }
       
       int count = 0;
       for (int i = 2; i < n; i++) {
           for (int j = 2; j < n; j++) {
               boolean canPlace = true;
               
               for (int k = 0; k < 8 && canPlace; k++) {
                   if (board[i + dx[k]][j + dy[k]] == 0) {
                       canPlace = false;
                   }
               }
               
               if (canPlace) {
                   for (int k = 0; k < 8; k++) {
                       board[i + dx[k]][j + dy[k]]--;
                   }
                   count++;
               }
           }
       }
       
       System.out.println(count);
       br.close();
   }
}