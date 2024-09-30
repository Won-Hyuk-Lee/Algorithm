import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append(getInitialConsonant(c));
        }
        System.out.println(result.toString());
    }
    public static char getInitialConsonant(char c) {
        if (c < '가' || c > '힣') {
            return c;
        }
        
        int code = (c - '가') / 588;
        
        switch (code) {
            case 0: return 'ㄱ';
            case 1: return 'ㄲ';
            case 2: return 'ㄴ';
            case 3: return 'ㄷ';
            case 4: return 'ㄸ';
            case 5: return 'ㄹ';
            case 6: return 'ㅁ';
            case 7: return 'ㅂ';
            case 8: return 'ㅃ';
            case 9: return 'ㅅ';
            case 10: return 'ㅆ';
            case 11: return 'ㅇ';
            case 12: return 'ㅈ';
            case 13: return 'ㅉ';
            case 14: return 'ㅊ';
            case 15: return 'ㅋ';
            case 16: return 'ㅌ';
            case 17: return 'ㅍ';
            case 18: return 'ㅎ';
            default: return c;
        }
    }
}