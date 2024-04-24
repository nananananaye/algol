import java.util.*;
class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int sx,sy,ex,ey;
    static char[][] arr;
    static boolean[][] visited;
        public int solution(String[] board) {
            int answer =-1;
            arr = new char[board.length][board[0].length()];
            visited = new boolean[board.length][board[0].length()];
            for(int i=0;i<board.length;i++){
                arr[i] = board[i].toCharArray();
                for(int j=0; j<arr[0].length;j++){
                    if(arr[i][j] == 'R'){
                        sx =i; sy=j;
                    }
                    if(arr[i][j] == 'G'){
                        ex =i; ey=j;
                    }
                }
            }
          //  System.out.println(sx+" "+sy+" "+ex+" "+ey);
            
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {sx,sy,0});
            visited[sx][sy] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
               // System.out.println("cur="+Arrays.toString(cur));
                if(cur[0]== ex && cur[1] == ey){
                //    System.out.println("!!!!!!"+cur[2]);
                    answer = cur[2];
                    break;
                }
                for(int d=0; d< 4;d++){
                    int x = cur[0] ;
                    int y = cur[1] ;
                    while(true){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(!check(nx,ny))break;
                        if(arr[nx][ny]=='D')break;
                        x= nx; y = ny;
                    }
                    if(x == cur[0] && y == cur[1]) continue;
                //    System.out.println("됴챡"+x+"  " +y);
                    if(!visited[x][y]){
                        visited[x][y] = true;
                        q.offer(new int[] {x,y,cur[2]+1});
                    }
                }
            }
       return answer;
    }
    public boolean check(int x , int y ){
        return 0<= x && x < arr.length && 0<=y && y< arr[0].length;
    }
}