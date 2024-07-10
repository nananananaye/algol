import java.util.*;
import java.io.*;

class Solution {
    static int T,N,M;
    static int[] p;
    static int[] r;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <T+1;t++){
            int answer = 0;
            HashSet<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N+1];
            r = new int[N+1];
            init();
            for(int i = 0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            for(int i = 1; i < p.length; i++){
                if(i == p[i]) answer++;
            }
            System.out.println("#"+t+" "+answer);
        }
        
    }
    public static void init(){
        for(int i = 1;i<N+1;i++){
            p[i] = i;
            r[i] = 1;
        }        
    }
    public static void union(int x , int y){
        x = findParent(x);
        y = findParent(y);
        if(x == y) return;
        if(r[x]<r[y]){
            r[y] += r[x];
            p[x] = y;
        }else{
            r[x] += r[y];
            p[y] = x;
        }
    }
    public static int findParent(int x){
        if(x == p[x]) return x;
        else return p[x] = findParent(p[x]);
    }
}