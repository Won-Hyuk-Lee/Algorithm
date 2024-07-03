import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0; //집합을 나타내는 비트마스크
        int M = Integer.parseInt(br.readLine()); //연산횟수

        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            String operation = input[0];
            
            switch (operation) {
                case "all":
                    S = (1 << 21) - 1; //모든 비트를 1로 설정
                    break;
                case "empty":
                    S = 0; //모든 비트를 0으로 설정
                    break;
                default:
                    int num = Integer.parseInt(input[1]);
                    switch (operation) {
                        case "add":
                            S |= (1 << num); //num 위치의 비트를 1로
                            break;
                        case "remove":
                            S &= ~(1 << num); //num 위치의 비트를 0으로
                            break;
                        case "check":
                            sb.append((S & (1 << num)) != 0 ? 1 : 0).append('\n'); // num이 집합에 있는지 확인
                            break;
                        case "toggle":
                            S ^= (1 << num); // num 위치의 비트 반전
                            break;
                    }
            }
        }
        System.out.print(sb);
    }
}