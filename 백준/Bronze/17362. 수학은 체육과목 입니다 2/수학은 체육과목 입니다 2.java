import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //패턴에 해당하는 손가락 번호
        int[] finger = {2, 1, 2, 3, 4, 5, 4, 3};
        
        //N % 8 == 0이면 8번째로
        System.out.println(finger[N % 8]);
    }
}
