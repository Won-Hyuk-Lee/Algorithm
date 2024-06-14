import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        long[] dist = new long[N - 1]; // 도시 간 거리
        long[] cost = new long[N]; // 리터당 기름 비용
        
        // 도시 간 거리
        for (int i = 0; i < N - 1; i++) {
            dist[i] = in.nextLong();
        }
        
        // 리터당 기름 비용
        for (int i = 0; i < N; i++) {
            cost[i] = in.nextLong();
        }
        
        long totalCost = 0; // 총 비용
        long minCost = cost[0]; // 현재까지의 최소 기름 비용
        
        // 최소 비용 계산
        for (int i = 0; i < N - 1; i++) {
            // 현재 주유소의 기름값이 더 저렴하면 최소 비용 갱신
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            
            // 최소 비용으로 거리만큼의 비용을 더함
            totalCost += (minCost * dist[i]);
        }
        
        System.out.println(totalCost);
    }
}
