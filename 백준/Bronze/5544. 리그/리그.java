import java.io.*;
import java.util.*;

public class Main {
    static class Team implements Comparable<Team> {
        int points = 0;
        int id;
        
        Team(int id) {
            this.id = id;
        }
        
        @Override
        public int compareTo(Team other) {
            return Integer.compare(this.points, other.points);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine().trim());
        Team[] teams = new Team[N];
        int[] ranks = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            teams[i] = new Team(i + 1);
        }
        
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(" ");
            int A = Integer.parseInt(parts[0]) - 1;
            int B = Integer.parseInt(parts[1]) - 1;
            int C = Integer.parseInt(parts[2]);
            int D = Integer.parseInt(parts[3]);
            
            if (C < D) {
                teams[B].points += 3;
            } else if (C > D) {
                teams[A].points += 3;
            } else {
                teams[A].points += 1;
                teams[B].points += 1;
            }
        }
        
        Arrays.sort(teams);
        
        ranks[teams[N - 1].id] = 1;
        int rank = 1;
        
        for (int i = N - 2; i >= 0; i--) {
            if (teams[i].points != teams[i + 1].points) {
                rank = N - i;
            }
            ranks[teams[i].id] = rank;
        }
        
        for (int i = 1; i <= N; i++) {
            sb.append(ranks[i]).append('\n');
        }
        
        System.out.print(sb);
    }
}