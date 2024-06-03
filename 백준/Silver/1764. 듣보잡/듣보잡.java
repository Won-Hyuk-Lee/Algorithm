import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        ArrayList<String> strList = new ArrayList<String>();

        // n개의 문자열 입력받아 set에 추가
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // m개의 문자열 입력받아 집합포함확인 후 리스트에 추가
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                strList.add(str);
            }
        }

        // 리스트 정렬
        Collections.sort(strList);

        // 결과 출력
        System.out.println(strList.size());
        for (String s : strList) {
            System.out.println(s);
        }
    }
}