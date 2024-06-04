class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0){
            int now = storey%10;
            storey /=10;
            if(now < 5){
                answer += now;
            }else if(now >5){
                answer += (10-now);
                storey += 1;
            }else if(now == 5){
                if(storey%10 >=5){
                    answer += (10-now);
                    storey +=1;
                }else{
                    answer += now;
                }
            }
        
        }
        return answer;
    }
}