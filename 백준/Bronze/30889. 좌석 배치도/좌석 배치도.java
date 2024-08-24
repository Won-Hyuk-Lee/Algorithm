import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        char[][] seat = new char[10][20];
        
        //전좌석 초기화
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                seat[i][j] = '.';
            }
        }
        
        //예매 입력
        for (int i = 0; i < n; i++) {
            String reservation = sc.next();
            
            //행
            int row = reservation.charAt(0) - 'A';
            
            //열
            int col = Integer.parseInt(reservation.substring(1)) - 1;
            
            //좌석배치
            seat[row][col] = 'o';
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(seat[i]);
        }
        sc.close();
    }
}
