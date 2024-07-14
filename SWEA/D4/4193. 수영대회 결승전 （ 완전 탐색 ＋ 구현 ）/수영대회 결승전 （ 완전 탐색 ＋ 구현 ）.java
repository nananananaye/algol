import java.util.*;
import java.io.*;

class Solution {
    static int T,N, sx,sy,ex,ey;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t < T+1 ; t++){
            int answer =-1;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new boolean[N][N];
            for(int i = 0; i < N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    
                }
            }
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {sx,sy,0});
            visit[sx][sy] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(cur[0] == ex && cur[1] == ey){
                    answer = cur[2];
                    break;
                }
                if(arr[cur[0]][cur[1]] == 2 && cur[2]%3 !=0){
                    q.offer(new int[] {cur[0],cur[1],cur[2]+1});
                    continue;
                }
                for(int d = 0 ; d < 4 ;d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(!check(nx,ny)) continue;
                    if(visit[nx][ny]) continue;
                    if(arr[nx][ny] == 1) continue;
                    q.offer(new int[] {nx,ny,cur[2]+1});
                    visit[nx][ny] = true;
                    
                }
                
            }
            System.out.println("#"+t+" "+answer);
        }
    }
    public static boolean check(int x, int y){
        return 0<= x && x < N && 0<= y && y< N;
    }

}