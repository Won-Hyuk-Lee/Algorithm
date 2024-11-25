import java.util.*;
import java.io.*;
 
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String[] pokemon = new String[n];
        int[] levelupCandy = new int[n];
        int[] haveCandy = new int[n];
        
        for(int i = 0; i < n; i++){
            pokemon[i] = br.readLine();
            st = new StringTokenizer(br.readLine());
            levelupCandy[i] = Integer.parseInt(st.nextToken());
            haveCandy[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int tempCount = 0;
        int index = 0;
        int maxCount = 0;
        for(int i = 0; i < n; i++){
            while(haveCandy[i] >= levelupCandy[i]){
                haveCandy[i] -= levelupCandy[i] - 2;
                tempCount++;
            }
            if(maxCount < tempCount){
                maxCount = tempCount;
                index = i;
            }
            count += tempCount;
            tempCount = 0;
        }
        System.out.println(count);
        System.out.println(pokemon[index]);
    }
}
