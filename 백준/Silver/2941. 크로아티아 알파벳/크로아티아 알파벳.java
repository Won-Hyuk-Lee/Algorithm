import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = str.length(); // 초기 문자 수를 문자열의 길이
        int i = 0; // 문자열 순회
        int length = str.length(); // 문자열의 길이저장

        // while 문자열 순회
        while (i < length) {
            if (str.charAt(i) == '-') { // 현재 문자가 '-'인 경우
                count--; // 문자의 수 1 줄임
            } else if (str.charAt(i) == '=') { // 현재 문자가 '='인 경우
                count--; // 문자의 수 1 줄임
                if (i > 1 && str.charAt(i - 1) == 'z' && str.charAt(i - 2) == 'd') { // 'dz=' 패턴 확인
                    count--; // 'dz=' 패턴은 단일 문자로 간주하므로 추가로 1 줄임
                }
            } else if (str.charAt(i) == 'j' && (i > 0 && (str.charAt(i - 1) == 'l' || str.charAt(i - 1) == 'n'))) {
                // 현재 문자가 'j'이고 앞 문자가 'l' 또는 'n'인 경우
                count--; // 'lj' 또는 'nj' 패턴은 단일 문자로 간주하므로 문자의 수를 1 줄임
            }
            i++; // 다음 문자를 확인하기 위해 인덱스를 증가
        }

        System.out.println(count);
        sc.close();
    }
}
