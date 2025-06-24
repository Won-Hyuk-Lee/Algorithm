import java.util.*;
import java.io.*;

public class Main {
    static class HanoiInfo {
        int count = 0;
        Stack<Character> A = new Stack<>();
        Stack<Character> B = new Stack<>();
        Stack<Character> C = new Stack<>();

        boolean emptyCheck(int index) {
            return switch (index) {
                case 0 -> A.isEmpty();
                case 1 -> B.isEmpty();
                default -> C.isEmpty();
            };
        }

        void stackClone(Stack<Character> a, Stack<Character> b, Stack<Character> c) {
            A = a;
            B = b;
            C = c;
        }

        void stackAdd(int index, Character stencil) {
            switch (index) {
                case 0 -> A.add(stencil);
                case 1 -> B.add(stencil);
                case 2 -> C.add(stencil);
            }
        }

        Character stackPop(int index) {
            return switch (index) {
                case 0 -> A.pop();
                case 1 -> B.pop();
                default -> C.pop();
            };
        }

        String getState() {
            return getStackString(A) + getStackString(B) + getStackString(C);
        }

        String getStackString(Stack<Character> stack) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            sb.append(" ");
            return sb.toString();
        }
    }

    static HashSet<String> visited = new HashSet<>();
    static HanoiInfo basic = new HanoiInfo();
    static int aCount, bCount, cCount;
    static String answerCode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) continue;
            String stencil = st.nextToken();
            for (int j = 0; j < n; j++) {
                char temp = stencil.charAt(j);
                switch (temp) {
                    case 'A' -> aCount++;
                    case 'B' -> bCount++;
                    case 'C' -> cCount++;
                }
                basic.stackAdd(i, temp);
            }
        }
        visited.add(basic.getState());
        answerCode = getAnswerCode();
        System.out.println(gameStart());
    }

    static int gameStart() {
        Queue<HanoiInfo> queue = new LinkedList<>();
        queue.add(basic);

        while (!queue.isEmpty()) {
            HanoiInfo cur = queue.poll();
            if (cur.getState().equals(answerCode)) return cur.count;

            for (int i = 0; i < 3; i++) {
                if (cur.emptyCheck(i)) continue;
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    char temp = cur.stackPop(i);
                    cur.stackAdd(j, temp);
                    String state = cur.getState();

                    if (!visited.contains(state)) {
                        visited.add(state);
                        HanoiInfo next = new HanoiInfo();
                        next.stackClone((Stack<Character>) cur.A.clone(), (Stack<Character>) cur.B.clone(), (Stack<Character>) cur.C.clone());
                        next.count = cur.count + 1;
                        queue.add(next);
                    }

                    cur.stackAdd(i, temp);
                    cur.stackPop(j);
                }
            }
        }
        return -1;
    }

    static String getAnswerCode() {
        return "A".repeat(aCount) + " " + "B".repeat(bCount) + " " + "C".repeat(cCount) + " ";
    }
}
