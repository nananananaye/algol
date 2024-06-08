class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[]{0,0};
        int n = arr.length;
        dfs(0,0,n,arr);
        return answer;
    }
    
    public void dfs(int x, int y,int len,int[][] arr){
         if(len == 1){
             answer[arr[x][y]]++;
             return;
         }
        if(isSame(x,y,len,arr)){
            answer[arr[x][y]]++;
            return;
        }else{
            dfs(x,y,len/2,arr);
            dfs(x+len/2,y,len/2,arr);
            dfs(x,y+len/2,len/2,arr);
            dfs(x+len/2,y+len/2,len/2,arr);
        }
    }
    
    public boolean isSame(int x, int y , int len, int[][] arr){
       
        for(int i = x ; i < x+len; i++){
            for(int j=y; j < y+len; j++){
                if(arr[x][y] != arr[i][j])return false;
            }
        }
        
        return true;
        
    }
}