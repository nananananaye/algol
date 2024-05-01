class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right =1;
        int sum = 1;
        while(left <= n){
           // System.out.println(left+" "+right+" =>"+sum);
            if(sum == n){
                answer++;
               sum -= left++;
        
            }else if(sum < n){
                sum += ++right;
            }else{
                sum -= left++;
            }
            
        }
        return answer;
    }
}