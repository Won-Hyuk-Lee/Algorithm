import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];     // 최종 상태
        int[] shuffleOrder = new int[n]; // 섞는 순서
        int[] cards = new int[n];      // 현재 카드 상태

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            shuffleOrder[Integer.parseInt(st.nextToken())] = i;
            cards[i] = i % 3;
        }

        int[] original = cards.clone();
        int[] temp = new int[n];
        int count = 0;

        while (!Arrays.equals(cards, target)) {
            for (int i = 0; i < n; i++) {
                temp[shuffleOrder[i]] = cards[i];
            }
            cards = temp.clone();
            count++;

            if (Arrays.equals(cards, original)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);
    }
}
