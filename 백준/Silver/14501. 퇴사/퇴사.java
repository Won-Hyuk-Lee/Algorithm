import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //상담 기간 (일수)

        int[] t = new int[n]; //각 상담에 필요한 기간
        int[] p = new int[n]; //각 상담에 대한 수입
        int[] maxP = new int[n + 1]; //최대 수입을 저장할 배열

        //상담 기간과 수입 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //최대 수입 계산
        for (int i = 0; i < n; i++) {
            //상담을 완료한 날짜가 n일을 넘지 않도록 함
            if (i + t[i] <= n) {
                maxP[i + t[i]] = Math.max(maxP[i + t[i]], maxP[i] + p[i]);
            }
            //다음 날의 수입을 현재까지의 최대 수입과 비교하여 갱신
            maxP[i + 1] = Math.max(maxP[i], maxP[i + 1]);
        }

        //n번째 날까지의 최대 수입
        System.out.println(maxP[n]);
    }
}
