import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //첫 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //저장할 문자열
        int M = Integer.parseInt(st.nextToken()); //찾을 문자열
        
        //저장할Map
        Map<String, String> map = new HashMap<>();
        
        //N개의 문자열 쌍 Map에
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        
        // M개 문자열 처리
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            bw.write(map.get(query) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}