import java.util.*;
class Solution {
    static List<Integer> ans = new ArrayList<>();
    static char[][] arr;
    static boolean[][] v;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int[] solution(String[] maps) {
        int[] answer;
        arr = new char[maps.length][maps[0].length()];
        v = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i < maps.length;i++){
            arr[i] = maps[i].toCharArray();
        }
        for(int i = 0; i < arr.length;i++){
            for(int j = 0 ; j< arr[0].length;j++){
                if(arr[i][j] != 'X' && !v[i][j]){
                    bfs(i,j);
                }
            }
        }
        if(ans.size() == 0) {
          answer = new int[1];
          answer[0] = -1;
        }else{
            Collections.sort(ans);
        answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++){
            answer[i] = ans.get(i);
        }
        }     
        return answer;
    }
    public void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        v[x][y] = true;
        int cnt = (arr[x][y]-48);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0 ; d < 4 ; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 'X') continue;
                if(v[nx][ny]) continue;
                q.offer(new int[] {nx,ny});
                v[nx][ny] = true;
                cnt += (arr[nx][ny]-48);
            }
            
        }
        ans.add(cnt);
    }
    public boolean check(int x , int y){
        return 0<= x && x < arr.length && 0<= y && y < arr[0].length;
    }
}