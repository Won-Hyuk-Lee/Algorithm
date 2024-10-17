import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());
        bw.write(4*(int)(Math.sqrt(2*n))+" ");
        bw.flush();
    }
}