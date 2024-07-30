import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        //N이 0일때 처리
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        //난이도 배열에 저장
        int[] difficulties = new int[N];
        for (int i = 0; i < N; i++) {
            difficulties[i] = Integer.parseInt(br.readLine());
        }
        
        //배열 오름차순 정렬
        Arrays.sort(difficulties);
        
        //절사평균 계산
        int cut = (int) Math.round(N * 0.15);
        
        int sum = 0;
        
        //계산할 애들 합
        for (int i = cut; i < N - cut; i++) {
            sum += difficulties[i];
        }
        
        //유효한 난이도 갯수
        int validCount = N - 2 * cut;
        
        //절사평균 계산후 반올림하고 출력합니다.
        System.out.println(Math.round((double) sum / validCount));
    }
}
