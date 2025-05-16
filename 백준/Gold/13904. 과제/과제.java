import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[][] t=new long[n][2];
        int maxD=0;
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int d=Integer.parseInt(st.nextToken())-1;
            long p=Long.parseLong(st.nextToken());
            t[i][0]=d;
            t[i][1]=p;
            if(d>maxD) maxD=d;
        }
        Arrays.sort(t, Comparator.comparingLong(a->a[0]));
        PriorityQueue<Long> pq=new PriorityQueue<>(Comparator.reverseOrder());
        long ans=0;
        int idx=n-1;
        for(int day=maxD;day>=0;day--){
            while(idx>=0 && t[idx][0]==day){
                pq.add(t[idx][1]);
                idx--;
            }
            if(!pq.isEmpty()) ans+=pq.poll();
        }
        System.out.print(ans);
    }
}
