import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int solved = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());

            list.add(new Pair(solved, penalty));
        }

        Collections.sort(list);
        int answer = 0;
        Pair fifth = list.get(4);

        for (int i = 5; i < list.size(); i++) {
            Pair now = list.get(i);

            if (fifth.solved == now.solved)
                answer++;
            else break;
        }

        System.out.println(answer);
    }

    static class Pair implements Comparable<Pair> {
        int solved, penalty;

        public Pair(int solved, int penalty) {
            this.solved = solved;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Pair p) {
            return this.solved == p.solved ? this.penalty - p.penalty : p.solved - this.solved;
        }
    }
}