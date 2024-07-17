import java.util.*;

public class Main {
    
    static int[] check; //방문여부
    
    public static void bfs(int start, int target) { //BFS 둘의 위치전달
        Queue<Integer> queue = new LinkedList<>();
        
        check[start] = 0; //수빈이 위치0으로
        queue.offer(start); 
        
        while(!queue.isEmpty()) { //큐가 빌 때까지
            int current = queue.poll();
            if (check[target] != 0) break; //동생의 위치가 0이 아니면 종료
                                           //배열 크기를 100,001로 설정하여 시간을 단축
            if (current - 1 >= 0 && check[current - 1] == 0) {
                queue.offer(current - 1);                      
                check[current - 1] = check[current] + 1;       //x-1
            }
            if (current < check.length - 1 && check[current + 1] == 0) {
                queue.offer(current + 1);
                check[current + 1] = check[current] + 1;       //x+1
            }
            if (current * 2 < check.length && check[current * 2] == 0) {
                queue.offer(current * 2);
                check[current * 2] = check[current] + 1;       //순간이동 x*2
            }
        }    
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        
        int n = sc.nextInt(); //수빈
        int k = sc.nextInt(); //동생
        check = new int[100001]; //위치범위
        
        if (n == k) { //같은위치
            System.out.println("0");
            return;
        }
        bfs(n, k); //BFS사용
        
        System.out.println(check[k]); //동생의 위치 출력
    }
}
