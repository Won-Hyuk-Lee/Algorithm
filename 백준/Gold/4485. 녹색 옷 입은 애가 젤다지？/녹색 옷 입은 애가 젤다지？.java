import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int x,y,c;
        Node(int x,int y,int c){this.x=x;this.y=y;this.c=c;}
        public int compareTo(Node o){return this.c-o.c;}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int idx=1;
        while(true){
            int n=Integer.parseInt(br.readLine());
            if(n==0) break;
            int[][] a=new int[n][n], d=new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) a[i][j]=Integer.parseInt(st.nextToken());
                Arrays.fill(d[i], Integer.MAX_VALUE);
            }
            PriorityQueue<Node> pq=new PriorityQueue<>();
            d[0][0]=a[0][0]; pq.add(new Node(0,0,d[0][0]));
            int[] dx={-1,1,0,0}, dy={0,0,-1,1};
            while(!pq.isEmpty()){
                Node u=pq.poll();
                if(u.c>d[u.x][u.y]) continue;
                for(int k=0;k<4;k++){
                    int nx=u.x+dx[k], ny=u.y+dy[k];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n){
                        int nc=u.c+a[nx][ny];
                        if(d[nx][ny]>nc){
                            d[nx][ny]=nc;
                            pq.add(new Node(nx,ny,nc));
                        }
                    }
                }
            }
            sb.append("Problem ").append(idx++).append(": ").append(d[n-1][n-1]).append('\n');
        }
        System.out.print(sb);
    }
}
