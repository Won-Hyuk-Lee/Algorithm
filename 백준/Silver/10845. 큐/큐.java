import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 명령의 수 입력
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성
        int last = 0; // 마지막으로 추가된 값 저장 변수
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 명령어 입력
            String command = st.nextToken(); // 명령어 추출
            
            switch(command) {
                case "push" :
                    last = Integer.parseInt(st.nextToken()); // 추가할 값 추출
                    queue.offer(last); // 큐에 값 추가
                    break;
                case "pop" :
                    if(queue.isEmpty()) sb.append(-1).append("\n"); // 큐가 비어있으면 -1 출력
                    else sb.append(queue.poll()).append("\n"); // 큐가 비어있지 않으면 첫번째 값 출력 및 제거
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n"); // 큐의 크기 출력
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n"); // 큐가 비어있으면 1, 아니면 0 출력
                    break;
                case "front" :
                    if(queue.isEmpty()) sb.append(-1).append("\n"); // 큐가 비어있으면 -1 출력
                    else sb.append(queue.peek()).append("\n"); // 큐의 첫번째 값 출력
                    break;
                case "back" :
                    if(queue.isEmpty()) sb.append(-1).append("\n"); // 큐가 비어있으면 -1 출력
                    else sb.append(last).append("\n"); // 마지막으로 추가된 값 출력
                    break;
            }
        }
        System.out.println(sb);
    }
    
}
