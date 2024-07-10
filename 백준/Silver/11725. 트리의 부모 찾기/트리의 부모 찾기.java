import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent; //부모 노드
    static boolean[] isVisit; //노드방문 여부
    static ArrayList<Integer>[] list; //노드 연결 관계 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        //노드 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1); //루트 노드부터 DFS

        //부모 노드 출력
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    //깊이우선탐색
    public static void dfs(int index) {
        isVisit[index] = true; //노드 방문 처리
        for (int i : list[index]) { //연결된 모든 노드를 순회
            if (!isVisit[i]) { //방문하지 않은 노드라면
                parent[i] = index; //해당 노드의 부모 노드를 현재 노드로 저장한다
                dfs(i); //해당 노드로 DFS를 계속 진행
            }
        }
    }
}
