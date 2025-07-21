import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static ArrayList<Integer>[] order;
    static String[] cards;
    static int[] personalCards, res, commands;
    static TreeSet<String> ans = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        order = new ArrayList[n + 1];
        cards = new String[c + 1];
        personalCards = new int[n + 1];
        res = new int[c + 1];
        commands = new int[c];
        
        Arrays.fill(res, -1);

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            personalCards[i] = cnt;
            order[i] = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                order[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= c; i++) {
            cards[i] = br.readLine();
        }

        generatePermutation(1, 0);
        
        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            sb.append(s).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }

    static void executeOperations() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < c; i++) {
            String[] ops = cards[commands[i]].split(",");
            
            for (String op : ops) {
                StringTokenizer token = new StringTokenizer(op);
                String command = token.nextToken();
                
                if ("ADD".equals(command)) {
                    sb.append(token.nextToken());
                } else {
                    try {
                        sb.deleteCharAt(Integer.parseInt(token.nextToken()));
                    } catch (Exception e) {
                        ans.add("ERROR");
                        return;
                    }
                }
            }
        }
        
        ans.add(sb.length() == 0 ? "EMPTY" : sb.toString());
    }

    static void generatePermutation(int personIdx, int cardCnt) {
        if (personIdx == n + 1) {
            int[] cardIdx = new int[n + 1];
            for (int i = 0; i < c; i++) {
                commands[i] = order[res[i]].get(cardIdx[res[i]]++);
            }
            executeOperations();
            return;
        }

        if (personalCards[personIdx] == 0) {
            generatePermutation(personIdx + 1, 0);
        } else {
            personalCards[personIdx]--;
            for (int i = cardCnt; i < c; i++) {
                if (res[i] < 0) {
                    res[i] = personIdx;
                    generatePermutation(personIdx, i + 1);
                    res[i] = -1;
                }
            }
            personalCards[personIdx]++;
        }
    }
}