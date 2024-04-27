import java.util.*;
class Solution {
    static String[] nums;
    static boolean[] visited; 
    static String[] res;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        nums = numbers.split("");
        visited = new boolean[nums.length];
        for(int k =1; k< nums.length+1;k++){
            res = new String[k];
            perm(0,k);
        }
        for(int x : set){
            if(isPrime(x)){
                answer++;
            }
       
    }
         return answer;
    }
    public void perm(int cnt, int k){
        if(cnt == k){
            String result="";
            for(String x : res){
                result += x;
            }
            set.add(Integer.parseInt(result));
            return;
        }
        for(int i = 0 ; i< nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            res[cnt] = nums[i];
            perm(cnt+1,k);
            visited[i]=false;
        }
    }
    public boolean isPrime(int x){
        if(x<=1) return false;
        for(int i =2 ; i < x ; i ++){
            if(x%i == 0) return false;
        }
        return true;
    }
}