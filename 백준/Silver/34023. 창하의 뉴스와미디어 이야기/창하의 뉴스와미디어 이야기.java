import java.io.*;
import java.util.*;

public class Main {
    static class Word {
        String name;
        int difficulty;
        
        Word(String name, int difficulty) {
            this.name = name;
            this.difficulty = difficulty;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Word[] words = new Word[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int difficulty = Integer.parseInt(st.nextToken());
            words[i] = new Word(name, difficulty);
        }
        
        Arrays.sort(words, (a, b) -> a.difficulty - b.difficulty);
        
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            groups.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N; i += 4) {
            for (int j = 0; j < 4; j++) {
                groups.get(j).add(words[i + j].name);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            Collections.sort(groups.get(i));
            bw.write((i + 1) + " ");
            for (int j = 0; j < groups.get(i).size(); j++) {
                if (j > 0) bw.write(" ");
                bw.write(groups.get(i).get(j));
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}