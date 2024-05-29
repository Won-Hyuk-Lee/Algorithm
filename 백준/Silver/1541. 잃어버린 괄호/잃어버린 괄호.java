import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int sum = 0;
        
        // 무조건 작은값에서 큰값을 빼야 최솟값을 만들 수 있다.
        String[] sub = str.split("-"); // -로 문자열을 자른다.
        
        for (int i = 0; i < sub.length; i++) {
            int temp = 0;
            String[] add = sub[i].split("\\+"); // 뺄셈으로 나눈 숫자들을 다시 덧셈을 기준으로 분리한다.
            
            // 덧셈으로 나눈 숫자들을 모두 더한다.
            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }
            
            // 첫번째 값에서부터 뺀다.
            if (i == 0) {
                sum = temp; // 첫번째 수는 더해준다.
            } else {
                sum -= temp; // 두번째 수부터는 뺀다.
            }
        }
        
        System.out.println(sum); // 최종 결과 출력
    }
}