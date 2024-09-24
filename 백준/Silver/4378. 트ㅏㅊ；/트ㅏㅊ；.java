import java.io.*;
public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String keyboard1 = "`1234567890-=";
       String keyboard2 = "QWERTYUIOP[]\\";
       String keyboard3 = "ASDFGHJKL;'";
       String keyboard4 = "ZXCVBNM,./";
       String[] keyboards = {keyboard1, keyboard2, keyboard3, keyboard4};

       String input = "";
       while((input = br.readLine()) != null){
           for(int i=0; i<input.length(); i++){
               char c = input.charAt(i);
               if(c == ' '){
                   bw.write(" ");
               }
               else{
                   for(int j=0; j<keyboards.length; j++){
                       if(keyboards[j].contains(c+"")){
                           bw.write(keyboards[j].charAt(keyboards[j].indexOf(c)-1));
                           break;
                       }
                   }
               }
           }
           bw.write("\n");
           bw.flush();
       }
   }
}