import java.util.*;  

class Solution {  
    boolean solution(String s) {  
        int count = 0; // 괄호의 개수를 셀 변수
        
        for (int i = 0; i < s.length(); i++) {  
            if (s.charAt(i) == '(') {  
                count++; // '('이면 카운트를 증가
            } else if (s.charAt(i) == ')') {  
                count--; // ')'이면 카운트를 감소
                if (count < 0) {  
                    return false; // 카운트가 음수가 되면 올바르지않음
                }  
            }  
        }  
        
        return count == 0; // 0이면 올바름
    }  
}
