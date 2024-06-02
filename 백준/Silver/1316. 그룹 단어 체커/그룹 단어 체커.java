import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = num;

        for (int i = 0; i < num; i++) {
            String str = sc.next();
            boolean test[] = new boolean[26]; // 알파벳 배열을 만들어서 이미 체크한 알파벳은 true

            for (int j = 0; j < str.length(); j++) { // i와 i+1을 비교
                if (j < str.length() - 1 && str.charAt(j) != str.charAt(j + 1)) { // i와 i+1이 다른경우
                    if (test[str.charAt(j + 1) - 'a'] == true) { // 이미 한번 체크된 알파벳일 경우 그룹단어X
                        count--; // 그룹단어가 아니라고 판단 될 경우 초기값인 단어의 수에서 1씩--
                        break;
                    }
                }
                test[str.charAt(j) - 'a'] = true; // 알파벳을 true처리 다음에 반복되는경우 제외 -97은 아스키코드로 a가 97이니 -97해주어 a를 0으로 나오게
            }
        }
        System.out.println(count); // 숫자를 출력한다.
    }
}
