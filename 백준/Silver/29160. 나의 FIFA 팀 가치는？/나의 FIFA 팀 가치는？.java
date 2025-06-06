import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = 0;

        List<PriorityQueue<Integer>> v = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            v.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        boolean[] isexist = new boolean[12];

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int w = sc.nextInt();
            v.get(p).add(w);
            isexist[p] = true;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= 11; j++) {
                if (isexist[j]) {
                    PriorityQueue<Integer> pq = v.get(j);
                    int tmp = pq.peek();
                    if (tmp == 1) break;
                    pq.poll();
                    pq.add(tmp - 1);
                }
            }
        }

        for (int i = 1; i <= 11; i++) {
            if (isexist[i]) {
                sum += v.get(i).peek();
            }
        }

        System.out.println(sum);
    }
}
