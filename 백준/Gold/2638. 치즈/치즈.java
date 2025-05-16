import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
        int[][] a=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) a[i][j]=Integer.parseInt(st.nextToken());
        }
        int[] dx={-1,1,0,0}, dy={0,0,-1,1}, time=new int[1];
        while(true){
            boolean[][] out=new boolean[N][M];
            Queue<int[]> q=new ArrayDeque<>();
            out[0][0]=true; q.add(new int[]{0,0});
            while(!q.isEmpty()){
                int[] p=q.poll();
                for(int k=0;k<4;k++){
                    int nx=p[0]+dx[k], ny=p[1]+dy[k];
                    if(nx>=0&&nx<N&&ny>=0&&ny<M&&!out[nx][ny]&&a[nx][ny]==0){
                        out[nx][ny]=true; q.add(new int[]{nx,ny});
                    }
                }
            }
            List<int[]> melt=new ArrayList<>();
            for(int i=0;i<N;i++) for(int j=0;j<M;j++) if(a[i][j]==1){
                int c=0;
                for(int k=0;k<4;k++){
                    int ni=i+dx[k], nj=j+dy[k];
                    if(ni>=0&&ni<N&&nj>=0&&nj<M&&out[ni][nj]) c++;
                }
                if(c>=2) melt.add(new int[]{i,j});
            }
            if(melt.isEmpty()) break;
            for(int[] p:melt) a[p[0]][p[1]]=0;
            time[0]++;
        }
        System.out.print(time[0]);
    }
}
