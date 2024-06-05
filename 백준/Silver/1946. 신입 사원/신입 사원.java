import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Grade implements Comparable<Grade> {
    int a; // 서류 점수
    int b; // 면접 점수

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Grade o) {
        return Integer.compare(this.a, o.a); // 서류 점수 기준으로 비교
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt(); // 테스트 케이스횟수

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt(); // 각 테스트 케이스의 지원자
            ArrayList<Grade> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt(); // 서류 점수 입력
                int b = sc.nextInt(); // 면접 점수 입력
                list.add(new Grade(a, b));
            }

            // 서류 점수 기준 오름차순 정렬
            Collections.sort(list);

            // 통과 가능한 지원자 수 계산
            int pass = 1; // 서류 1등 기본 pass
            int min = list.get(0).b; // 첫 번째 지원자의 면접 점수를 최소값으로 설정
            for (int i = 1; i < n; i++) {
                if (list.get(i).b < min) 
                { 
                    pass++; // 현재 지원자의 면접 점수가 최소값보다 작으면 통과
                    min = list.get(i).b; // 최소 면접 점수를 갱신
                }
            }
            System.out.println(pass);
        }
        sc.close();
    }
}
