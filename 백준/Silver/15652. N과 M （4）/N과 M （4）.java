import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] sequence; //수열 저장 배열
    static StringBuilder output = new StringBuilder();
    static int maxNumber; //M 최대 숫자
    static int sequenceLength; //N 수열의 길이
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        maxNumber = Integer.parseInt(st.nextToken());
        sequenceLength = Integer.parseInt(st.nextToken());
        
        sequence = new int[sequenceLength];
        
        //DFS 시작
        generateSequence(1, 0);
        System.out.print(output.toString());
    }

    //DFS로 수열 생성
    public static void generateSequence(int start, int depth) {
        
        //수열이 목표 길이에 도달하면 출력시킴
        if(depth == sequenceLength) {
            for(int num : sequence) {
                output.append(num).append(" ");
            }
            output.append("\n");
            return;
        }
        
        //중복을 허용하며 오름차순? 비내림차순? 수열 생성
        for(int i = start ; i <= maxNumber; i++) {
            sequence[depth] = i;
            generateSequence(i, depth + 1);
        }
    }
}
