import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        
        Arrays.sort(chars, Collections.reverseOrder());
        
        StringBuilder sortedStr = new StringBuilder(chars.length);
        for (char c : chars) {
            sortedStr.append(c);
        }
        
        return answer = Long.parseLong(sortedStr.toString());
    }
}