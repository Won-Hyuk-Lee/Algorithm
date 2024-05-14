class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if (a>b)
        {
            while(a>=b)
            {
                answer+=b;
                b++;
            }
        }
        else if(a<b)
        {
            while(a<=b)
            {
                answer+=a;
                a++;
            }
        }
        else answer = a;
        return answer;
    }
}