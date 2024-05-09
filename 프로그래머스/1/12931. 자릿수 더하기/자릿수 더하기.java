import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Converter(n);
        
        while(n>=10){
            answer += n%10;
            n/=10;
        }
        answer +=n;

        return answer;
    }


public static int Converter(int num){
    return String.valueOf(num).length();
}
}