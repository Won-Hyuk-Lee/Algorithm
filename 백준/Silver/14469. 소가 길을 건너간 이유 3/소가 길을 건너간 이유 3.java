import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int endTime = 0;
        int cowArr[][] = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cowArr[i][0] = Integer.parseInt(st.nextToken());
            cowArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cowArr, (o1,o2)-> o1[0]-o2[0]);
        
        for(int i=0;i<N;i++){
            if(endTime < cowArr[i][0]){
                endTime=cowArr[i][0]+cowArr[i][1];
            }
            else
                endTime += cowArr[i][1];
        }
        bw.write(endTime+"");
        bw.flush();
        bw.close();
    }
}