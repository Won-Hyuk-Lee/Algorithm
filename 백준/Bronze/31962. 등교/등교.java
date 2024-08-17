import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  //버스 대수
        int X = sc.nextInt();  //도착해야 하는 시간
        
        List<int[]> busInfo = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();  //버스 출발시간
            int T = sc.nextInt();  //버스 도착시간
            busInfo.add(new int[]{S, T});
        }
        
        //버스 출발 시간 내림차순 정렬
        busInfo.sort((a, b) -> b[0] - a[0]);
        
        boolean arriveCheck = false;
        int takeTime = -1;
        
        //버스 확인
        for (int[] bus : busInfo) {
            int S = bus[0];  //버스출발시간
            int T = bus[1];  //걸리는 시간
            
            if (S + T > X) {
                continue;
            } else {
                arriveCheck = true;
                takeTime = S;
                break;
            }
        }
        
        if (arriveCheck) {
            System.out.println(takeTime);
        } else {
            System.out.println(-1);
        }
        
        sc.close();
    }
}
