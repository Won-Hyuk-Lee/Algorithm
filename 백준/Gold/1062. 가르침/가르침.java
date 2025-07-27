import java.util.*;

public class Main {
   static int n, k, max = 0;
   static int[] words;
   static final int BASIC = (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a'));
   
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       k = sc.nextInt();
       sc.nextLine();
       
       if (k < 5) {
           System.out.println(0);
           return;
       } else if (k == 26) {
           System.out.println(n);
           return;
       }
       
       words = new int[n];
       for (int i = 0; i < n; i++) {
           String s = sc.nextLine();
           for (int j = 4; j < s.length() - 4; j++) {
               words[i] |= (1 << (s.charAt(j) - 'a'));
           }
       }
       
       dfs(0, 0, BASIC);
       System.out.println(max);
   }
   
   static void dfs(int idx, int cnt, int mask) {
       if (cnt == k - 5) {
           int count = 0;
           for (int word : words) {
               if ((word & mask) == word) count++;
           }
           max = Math.max(max, count);
           return;
       }
       
       for (int i = idx; i < 26; i++) {
           if ((mask & (1 << i)) == 0) {
               dfs(i + 1, cnt + 1, mask | (1 << i));
           }
       }
   }
}