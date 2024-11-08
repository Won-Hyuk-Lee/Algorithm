import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int sCnt = 0;
        int bCnt = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.substring(i, i+1).equals("s")) {
                sCnt++;
            } else if(str.substring(i, i+1).equals("b")) {
                bCnt++;
            }
        }
        
        if(sCnt > bCnt) {
            System.out.println("security!");
            return;
        } else if(bCnt > sCnt) {
            System.out.println("bigdata?");
        } else if(bCnt == sCnt) {
            System.out.println("bigdata? security!");
        }
    }
}
