import java.util.*;

public class Main {
    static class Rect {
        int x1, y1, x2, y2;

        Rect(int x1, int y1, int x2, int y2) {
            this.x1 = Math.min(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.x2 = Math.max(x1, x2);
            this.y2 = Math.max(y1, y2);
        }

        boolean overlaps(Rect r) {
            if (x2 < r.x1 || r.x2 < x1 || y2 < r.y1 || r.y2 < y1)
                return false;

            if (r.x1 < x1 && r.x2 > x2 && r.y1 < y1 && r.y2 > y2)
                return false;

            if (x1 < r.x1 && x2 > r.x2 && y1 < r.y1 && y2 > r.y2)
                return false;

            return true;
        }

        boolean overlapsOrigin() {
            return overlaps(new Rect(0, 0, 0, 0));
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Rect[] rects = new Rect[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            rects[i] = new Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (rects[i].overlaps(rects[j]))
                    union(i, j);

        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < n; i++)
            groups.add(find(i));

        for (int i = 0; i < n; i++) {
            if (rects[i].overlapsOrigin()) {
                groups.remove(find(i));
                break;
            }
        }

        System.out.println(groups.size());
    }
}
