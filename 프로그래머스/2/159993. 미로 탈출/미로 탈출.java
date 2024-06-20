import java.util.*;
class Solution {
    static char[][] arr;
    static int sx,sy,ex,ey,lx,ly;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String[] maps) {
        int answer = 0;
        arr = new char[maps.length][maps[0].length()];
        boolean[][] v2 = new boolean[maps.length][maps[0].length()];
        boolean[][] v3 = new boolean[maps.length][maps[0].length()];
        
        for(int i= 0 ; i < maps.length; i++){
            for(int j=0; j < maps[0].length();j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] == 'S'){
                    sx = i; sy=j;
                }
                if(arr[i][j] == 'E'){
                    ex = i; ey=j;
                }
                if(arr[i][j] == 'L'){
                    lx = i; ly=j;
                }
            }
        }

        int distSToL = calculate(sx,sy,lx,ly,v2);
        int distLToE = calculate(lx,ly,ex,ey,v3);
        if( distSToL == -1 || distLToE == -1){
            answer = -1;
        }else{
            answer = distSToL + distLToE;
        }
        return answer;
    }
    
    static int calculate(int startX,int startY,int endX,int endY ,boolean[][] visit){
        int res = -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX,startY,0});
        visit[startX][startY] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == endX && now[1] == endY){
                res = now[2];
                break;
            }
            for(int d = 0 ; d< 4 ; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 'X') continue;
                if(visit[nx][ny]) continue;
                    
                visit[nx][ny] = true;
                q.offer(new int[] {nx,ny,now[2]+1});
                
            }
            
        }
        return res;
    }
    static boolean check(int x, int y ){
        return 0<= x && x < arr.length && 0<= y && y < arr[0].length;
    }
}