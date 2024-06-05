import java.util.*;
class Solution {
    char[][] arr;
    int M,N;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        int a = 0;
        init(m,n,board);
        while(true){
            Set<Integer> res  = find();
            if(res.size() == 0) break;
            answer += res.size();
            pop(res);
            down();
        }
        return answer;
    }
    public void  down(){
       
        for(int j = 0 ; j < N;j++){
            Stack<Character> stack = new Stack<>();
            for(int i = 0 ; i < M;i++){
                if(arr[i][j]=='0') continue;
                stack.push(arr[i][j]);
                arr[i][j]='0';
            }
           // System.out.println(stack);
            int ind = M-1;
            while(!stack.isEmpty()){
                arr[ind--][j] = stack.pop();
            }
        }
      
        
    }
    public void pop(Set<Integer> res){
        for(int x: res){
            //System.out.println(x+ " "+ (x/N) + " "+(x%N));
            arr[x/N][x%N] = '0';
        }
        
    }   
    public Set<Integer> find(){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < M-1; i ++){
            for(int j= 0 ; j < N-1 ; j++){
                if(arr[i][j] == '0') continue;
                char now = arr[i][j];
                if(now == arr[i+1][j] && now == arr[i+1][j+1] && now == arr[i][j+1]){
                    set.add((i*N+j));
                    set.add(((i+1)*N+j));
                    set.add((i*N+(j+1)));
                    set.add(((i+1)*N+(j+1)));
                }
            }
        }
        return set;
    }
    
    public void init(int m, int n, String[] board){
        arr = new char[m][n];
        for(int i = 0; i < m; i ++){
            for(int j= 0 ; j < n ; j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
    }
}