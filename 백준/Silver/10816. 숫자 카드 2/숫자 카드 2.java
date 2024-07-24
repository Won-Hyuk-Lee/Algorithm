import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Cards = Integer.parseInt(br.readLine()); //카드
        HashMap<Integer, Integer> cardCountMap = new HashMap<>(); //빈도저장
        StringBuilder result = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Cards; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1); //빈도++
        }
        
        int numQueries = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numQueries; i++) {
            int query = Integer.parseInt(st.nextToken());
            result.append(cardCountMap.getOrDefault(query, 0)).append(" ");
        }
        
        System.out.println(result);
    }
}
