import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] ch = number.toCharArray();
        int[] arr = new int[number.length()];
        for(int i = 0 ; i < number.length(); i++){
            arr[i] = ch[i] -48;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < arr.length;i++){
            if(stack.isEmpty()){ 
                stack.push(arr[i]);
                continue;
            }
            while(!stack.isEmpty() && k>0){
                if(stack.peek() >= arr[i])  break;
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        int[] ans = new int[stack.size()];
        for(int i=stack.size()-1 ; i>=0 ; i--){
            ans[i] = stack.pop();
        }
        for(int x : ans){
            answer+= x;
        }
        return answer;
    }
}