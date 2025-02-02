import java.util.*;

public class Main {
   public static void main(String[] args) {
       var sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       sc.nextLine();

       char[][] board = new char[N][M];
       for (int i = 0; i < N; i++) {
           board[i] = sc.nextLine().toCharArray();
       }
       
       var clues = new ArrayList<int[]>();
       
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               if (board[i][j] == '.') {
                   boolean isAcrossStart = (j == 0 || board[i][j - 1] == '#') && 
                                           (j + 2 < M && board[i][j + 1] == '.' && board[i][j + 2] == '.');
                   boolean isDownStart = (i == 0 || board[i - 1][j] == '#') && 
                                         (i + 2 < N && board[i + 1][j] == '.' && board[i + 2][j] == '.');
                   
                   if (isAcrossStart || isDownStart) {
                       clues.add(new int[]{i + 1, j + 1});
                   }
               }
           }
       }
       
       System.out.println(clues.size());
       for (var clue : clues) {
           System.out.println(clue[0] + " " + clue[1]);
       }
   }
}