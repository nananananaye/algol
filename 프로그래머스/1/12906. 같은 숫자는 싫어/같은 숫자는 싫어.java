import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer  ;
        Stack<Integer> stack = new Stack<>();
        for(int x : arr){
            if(! stack.isEmpty() && stack.peek() == x) continue;
             stack.push(x);
        }
      
        answer = new int[stack.size()];
        for(int i = stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}