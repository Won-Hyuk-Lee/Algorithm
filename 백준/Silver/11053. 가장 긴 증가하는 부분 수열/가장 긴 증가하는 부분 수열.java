import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sequenceLength = Integer.parseInt(reader.readLine()); //수열 길이
        int[] sequence = new int[sequenceLength + 1]; //수열 초기화
        int[] lisLength = new int[sequenceLength + 1]; //LIS 길이 저장할 dp
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        for (int i = 1; i <= sequenceLength; i++) {
            sequence[i] = Integer.parseInt(tokenizer.nextToken()); //수열 원소 입력
            lisLength[i] = 1; //LIS 초기 길이 1로
        }
        
        int maxLength = 1; //최대 증가 부분 수열 길이 저장
        
        for (int i = 1; i <= sequenceLength; i++) {
            for (int j = 1; j < i; j++) {
                //현재 보다 작은 것들을 탐색, LIS 갱신
                if (sequence[i] > sequence[j]) {
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, lisLength[i]); //최대 길이 갱신시킴
        }
        
        System.out.print(maxLength); //가장 많이 증가한 부분 수열의 길이 출력
    }
}
