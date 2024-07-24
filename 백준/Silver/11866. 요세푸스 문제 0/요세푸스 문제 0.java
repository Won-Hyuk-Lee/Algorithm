import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //total
        int k = sc.nextInt(); //간격
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i); //1부터 n까지 큐에
        }

        int cnt = 0;
        while (queue.size() > 1) { //큐사이즈 1이 될 때까지
            cnt++;
            if (cnt % k == 0) {
                sb.append(queue.poll()).append(", "); //k번째 제거하고 결과로
            } else {
                queue.add(queue.poll()); //k번째가 아니면 뒤로
            }
        }

        sb.append(queue.poll()).append(">"); //마지막 넣고 형식 맞춤
        System.out.println(sb);
    }
}
