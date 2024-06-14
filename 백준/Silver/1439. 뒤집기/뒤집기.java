import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count0 = 0, count1 = 0;

        // 초기값
        char prevChar = s.charAt(0);
        if (prevChar == '0') {
            count0++;
        } else {
            count1++;
        }

        // 문자열 순회
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != prevChar) {
                if (currentChar == '0') {
                    count0++;
                } else {
                    count1++;
                }
                prevChar = currentChar;
            }
        }

        // 더 작은 그룹 수 출력
        System.out.println(Math.min(count0, count1));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
