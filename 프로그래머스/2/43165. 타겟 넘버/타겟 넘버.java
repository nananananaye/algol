class Solution {
    static int[] numbers;
    static int target,answer=0;
    public int solution(int[] nums, int t) {
        
        target = t;
        numbers = nums;
        dfs(0,0);
        return answer;
    }
    static void dfs(int cnt, int res){
        if(cnt == numbers.length){
            if(res == target) answer ++;
            return;
        }
        
        dfs(cnt+1, res+numbers[cnt]);
        dfs(cnt+1,res-numbers[cnt]);
    }
}