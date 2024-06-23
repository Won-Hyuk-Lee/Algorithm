import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isVisited; // 방문 여부를 확인
    static ArrayList<ArrayList<Integer>> adjList; // 인접 리스트로 그래프 표현 대신
    static int count = 0; // 감염된 컴퓨터 수
    
    static int node, line; // 노드와 간선

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드 수와 간선 수 입력
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
    
        // 인접 리스트 초기화
        adjList = new ArrayList<>();
        for(int i = 0; i <= node; i++) {
            adjList.add(new ArrayList<>());
        }

        // 방문 배열 초기화
        isVisited = new boolean[node+1];
        
        // 간선 정보 인접 리스트에 추가
        for(int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        // 1번 컴퓨터부터
        dfs(1);
        
        // 1번 컴퓨터는 제외
        System.out.println(count - 1);
    }

    // DFS
    public static void dfs(int start) {
        
        isVisited[start] = true; // 현재 노드 방문 체크
        count++; // 감염된 컴퓨터 수 증가
        
        // 현재 노드와 연결된 모든 노드 방문
        for(int next : adjList.get(start)) {
            if(!isVisited[next]) { // 아직 방문하지 않은 노드일 경우
                dfs(next); //재귀호출
            }
        }
    }
}
