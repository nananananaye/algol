import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int T,N,answer;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T+1 ;t++){
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            arr= new int[N][N];
            visit = new boolean[N];
            for(int i = 0 ; i < N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j< N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //
            dfs(0);
            

            System.out.println("#"+t+" "+answer);
        }
        
    }
    public static void dfs(int cnt){
        if(cnt == N){
            int num =0;
            for(int i = 0; i< N;i++){
                if(visit[i]) num++;
            }
            if(num == N/2) calculate(visit);
            return;
        }

        visit[cnt] = true;
        dfs(cnt+1);
        visit[cnt] = false;
        dfs(cnt+1);
        
        
    }
    
    public static void calculate(boolean[] visit){
        int A = sum(visit,true);
        int B = sum(visit,false);
        if(Math.abs(A-B) < answer) answer = Math.abs(A-B); 
    }
    
    public static int sum(boolean[] visit, boolean x){
        int res = 0;
        for(int i= 0 ;i< N;i++){
            if(visit[i] != x) continue;
            for(int j=i+1; j<N;j++){
                if(visit[j] != x) continue;
                res += (arr[i][j] + arr[j][i]);
                
            }
        }

        return res;
    }
}