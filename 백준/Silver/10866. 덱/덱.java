import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ArrayDeque를 사용하여 deque구현
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        int numCommands = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCommands; i++) {

            // 명령을 공백을 기준으로 분리
            String[] command = br.readLine().split(" ");

            // 명령어에 따른 처리
            switch (command[0]) {

                // 덱 앞 요소 추가
                case "push_front": {
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                }

                // 덱 뒤 요소 추가
                case "push_back": {
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                }

                // 덱 앞 요소 제거
                case "pop_front": {
                    if (deque.isEmpty()) {
                        output.append(-1).append('\n');
                    } else {
                        output.append(deque.pollFirst()).append('\n');
                    }
                    break;
                }

                // 덱 뒤 요소 제거
                case "pop_back": {
                    if (deque.isEmpty()) {
                        output.append(-1).append('\n');
                    } else {
                        output.append(deque.pollLast()).append('\n');
                    }
                    break;
                }

                // 덱의 크기
                case "size": {
                    output.append(deque.size()).append('\n');
                    break;
                }

                // 덱이 비어 있는지
                case "empty": {
                    if (deque.isEmpty()) {
                        output.append(1).append('\n');
                    } else {
                        output.append(0).append('\n');
                    }
                    break;
                }

                // 덱의 앞 요소 출력
                case "front": {
                    if (deque.isEmpty()) {
                        output.append(-1).append('\n');
                    } else {
                        output.append(deque.peekFirst()).append('\n');
                    }
                    break;
                }

                // 덱의 뒤 요소 출력
                case "back": {
                    if (deque.isEmpty()) {
                        output.append(-1).append('\n');
                    } else {
                        output.append(deque.peekLast()).append('\n');
                    }
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
