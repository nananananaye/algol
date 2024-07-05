import java.util.*;
import java.io.*;

class Solution {
    static int T;
    static String[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static HashSet<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t= 1 ; t < T+1 ; t++){
            set = new HashSet<>();
            StringTokenizer st;
            arr = new String[4][4];
            for(int i=0;i<4;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<4;j++){
                    arr[i][j] = st.nextToken();
                }
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    dfs(i,j,"",0);
                }
            }
            System.out.println("#"+t+" "+set.size());
        }
    }
    public static void dfs(int x, int y,String res, int len){
        res += arr[x][y];
        
        if(len == 6 ){
            set.add(res);
            return;
        }
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!check(nx,ny)) continue;
            dfs(nx,ny,res, len+1);
            
        }
    }
    public static boolean check(int x, int y){
        return 0<= x  && x< 4 && 0<= y && y<4;
    }
}