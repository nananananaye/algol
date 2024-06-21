import java.util.*;
class Solution {
    static int[][] arr= new int[102][102];
    static boolean[][] visit = new boolean[102][102];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dx8 = {-1,-1,0,1,1,1,0,-1};
    static int[] dy8 = {0,1,1,1,0,-1,-1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int[] rect : rectangle){
            draw(rect);
        }
        characterX *=2;
        characterY *=2;
        itemX *=2;
        itemY *=2;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterX,characterY,0});
        visit[characterX][characterY] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == itemX && now[1] == itemY){
                answer = now[2]/2;
            }
            for(int d = 0 ; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(!check(nx,ny)) continue;
                if(arr[nx][ny]==0) continue;
                if(visit[nx][ny]) continue;
                if(!isBorder(nx,ny)) continue;
                visit[nx][ny] = true;
                q.offer(new int[] {nx,ny,now[2]+1});
                    
            }
        }
        return answer;
    }
    public boolean isBorder(int x, int y){
        for(int d = 0 ; d < 8; d++){
            int nnx = x + dx8[d];
            int nny = y + dy8[d];
            if(arr[nnx][nny] ==0) return true;
        }
        return false;
    }
    public boolean check(int x, int y){
        return 0<= x && x<arr.length && 0<= y && y <arr[0].length;
    }
    public void draw(int[] rect){
        for(int i= rect[0]*2 ; i < rect[2]*2+1;i++){
            for(int j=rect[1]*2; j < rect[3]*2+1;j++){
                arr[i][j] = 1;
            }
        }
    }
}