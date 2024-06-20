import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,1000000};
        int start = 0;
        int end = 0;
        int sum =sequence[0];
        while(start<sequence.length && end < sequence.length){
        
            if(sum==k){
                if((answer[1]-answer[0]) > (end-start)){
                    answer[0] = start;
                    answer[1] = end;
                }
                if(end< sequence.length-1){
                sum += sequence[++end];
                }else{
                    sum -= sequence[start++];
                }
            }else if(sum < k){
                if(end< sequence.length-1){
                sum += sequence[++end];
                }else{
                    sum -= sequence[start++];
                }
            }else{
                sum -= sequence[start++];
            }
        }
        return answer;
    }
}