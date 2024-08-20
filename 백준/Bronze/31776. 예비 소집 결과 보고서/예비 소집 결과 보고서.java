import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int teamCount = Integer.parseInt(reader.readLine());
        int hardWorkTeams = 0;  //성실한 팀

        for (int i = 0; i < teamCount; i++) {
            //각 시간 입력
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int problem1 = Integer.parseInt(tokenizer.nextToken());
            int problem2 = Integer.parseInt(tokenizer.nextToken());
            int problem3 = Integer.parseInt(tokenizer.nextToken());


            if (problem1 != -1) {  //1번 문제를 해결한 경우
                if ((problem2 == -1 && problem3 == -1) ||  //2번과 3번 문제를 모두 해결하지 않은 경우
                    (problem2 != -1 && problem1 <= problem2 && (problem3 == -1 || problem2 <= problem3))) {  //2번 문제 해결 및 순서 만족한 경우와 3번 문제는 풀지 않았거나 순서 만족한 경우
                    hardWorkTeams++;
                }
            }
        }
        System.out.println(hardWorkTeams);
    }
}
