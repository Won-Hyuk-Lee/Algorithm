import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        List<Pair> input = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            input.add(new Pair(P, S));
        }
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            List<Pair> tmp = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {
                Pair p = input.get(j);
                if (i == j) {
                    tmp.add(new Pair(p.first / 2, p.second));
                } else {
                    tmp.add(new Pair(p.first, p.second));
                }
            }
            
            Collections.sort(tmp, (a, b) -> (a.first + a.second) - (b.first + b.second));
            
            int m = B;
            int cnt = 0;
            
            for (int j = 0; j < N; j++) {
                m -= tmp.get(j).first + tmp.get(j).second;
                if (m >= 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        System.out.println(answer);
    }
    
    static class Pair {
        int first;
        int second;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}