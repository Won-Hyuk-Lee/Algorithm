import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int answer=0;
        for(int i=0;i<8;i++){
            String a=br.readLine();
            for(int j=0;j<8;j++){
                char c=a.charAt(j);
                if(c=='P')answer++;
                else if(c=='N'||c=='B')answer+=3;
                else if(c=='R')answer+=5;
                else if(c=='Q')answer+=9;
                else if(c=='p')answer--;
                else if(c=='n'||c=='b')answer-=3;
                else if(c=='r')answer-=5;
                else if(c=='q')answer-=9;
            }
        }
        System.out.print(answer);
    }
}