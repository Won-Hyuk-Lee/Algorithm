import java.util.*;

class Solution {
  public long solution(long n) {
      Double sqrt = Math.sqrt(n); //제곱근
      
      if(sqrt == sqrt.intValue()) //제곱근이 맞다면 인트형으로 바꿔도 그대로 정수일거니까
      {
          return (long)Math.pow(sqrt + 1, 2);
      }
      else
      {
          return -1;
      }
  }
}