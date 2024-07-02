import java.util.*;

class Solution {
    static int N;
    
    public int[] solution(int n) {
        int last = n*(n+1)/2;
        int[] answer = new int[last];
        N = n;
        int[][] arr = new int[n][n];
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int x = 0;
        int y = 0;
        int d = 0;
        
        for(int i = 1; i< last+1 ; i++){
            arr[x][y] = i;        
            if(check(x+dx[d],y+dy[d]) && arr[x+dx[d]][y+dy[d]] ==0 ){
                x += dx[d];
                y += dy[d];
            }else{
                d= (d+1)%3;
                x += dx[d];
                y += dy[d];
            }
        }
        
        int ind=0;
        for(int i = 0 ;i<N;i++){
            for(int j = 0 ; j< i+1;j++){
                answer[ind++] = arr[i][j];
            }
        }
        return answer;
  
    }
    
    public boolean check(int x , int y){
        return 0<= x && x < N && 0<= y && y < N;
    }
}