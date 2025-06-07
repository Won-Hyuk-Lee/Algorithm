import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] digit = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        makeNum();
        Collections.sort(list);
        
        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }
    
    private static void makeNum() {
        for (int i = 1; i < (1 << 10); i++) {
            long num = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) > 0) {
                    num = num * 10 + digit[j];
                }
            }
            list.add(num);
        }
    }
}