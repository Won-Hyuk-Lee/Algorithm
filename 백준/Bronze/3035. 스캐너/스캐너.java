import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());
        String[] str = new String[R];
        for (int i = 0; i < R; i++) {
            str[i] = br.readLine();
        }
        if (ZC > 1) {
            for (int i = 0; i < R; i++) {
                String temp = "";
                for (int j = 0; j < C; j++) {
                    for (int k = 0; k < ZC; k++) {
                        temp += str[i].charAt(j);
                    }
                }
                str[i] = temp;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < ZR; j++) {
                sb.append(str[i]).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}