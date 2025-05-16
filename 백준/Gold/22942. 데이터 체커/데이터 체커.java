import java.util.*;

public class Main {
    static class Pair {
        int pos, id;
        Pair(int pos, int id) {
            this.pos = pos;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Pair> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), r = sc.nextInt();
            events.add(new Pair(x - r, i)); // 시작
            events.add(new Pair(x + r, i)); // 끝
        }

        events.sort(Comparator.comparingInt(p -> p.pos));

        Stack<Integer> stack = new Stack<>();
        for (Pair p : events) {
            if (!stack.isEmpty() && stack.peek() == p.id)
                stack.pop(); // 짝 맞음
            else
                stack.push(p.id); // 새 원 열림
        }

        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
}
