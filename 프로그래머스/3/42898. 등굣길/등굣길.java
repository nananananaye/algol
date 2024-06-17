import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] pud : puddles){
            map[pud[1]-1][pud[0]-1]= -1;
        }
        
        for(int i= 1; i<n ; i++){
            if(map[i][0] == -1) break;
            map[i][0] = 1;    
        }
        for(int j= 1; j<m ; j++){
            if(map[0][j] == -1) break;
            map[0][j] = 1;    
        }
        
        for(int i = 1; i<n ; i++){
            for(int j=1; j<m; j++){
                if(map[i][j] == -1) continue;
            
                if(map[i-1][j] != -1){
                    map[i][j] += map[i-1][j];
                }
                if(map[i][j-1] != -1){
                    map[i][j] += map[i][j-1];
                }
                map[i][j]%=1000000007;
            }
        }
        
        // for(int i = 0 ; i< n;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        return map[n-1][m-1];
    }
}