import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //결과 저장
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //공백을 기준으로 저장
        String[] temp = in.readLine().split(" ");

        //가능한 숫자
        int N = Integer.parseInt(temp[0]);
        //선택할 숫자
        int M = Integer.parseInt(temp[1]);

        result = new int[M];

        //조합 생성
        get_NM(N, M, 1, 0);

        System.out.println(sb);
    }

    //조합 생성
    private static void get_NM(int N, int M, int start, int depth) {
        //M개의 숫자
        if (depth == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        //가능한 숫자만큼 반복
        for (int i = start; i <= N; i++) {
            //결과 배열저장
            result[depth] = i;
            //재귀 호출
            get_NM(N, M, i + 1, depth + 1);
        }
    }
}
