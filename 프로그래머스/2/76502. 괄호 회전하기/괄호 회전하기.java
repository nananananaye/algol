import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();
        for(int i = 0 ;i< ch.length; i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j= 0 ; j< ch.length;j++){
                //System.out.println((i+j)%ch.length);
                int now = (i+j)%ch.length ;
                if(ch[now] == '[' || ch[now] == '(' || ch[now] == '{' ){
                    stack.push(ch[now]);
                }else{
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    if((ch[now] == ']' && stack.peek() == '[') || (ch[now] == '}' && stack.peek() == '{') || (ch[now] == ')' && stack.peek() == '(')){
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){ flag = false;}
            if(flag) answer++;
            System.out.println();
        }
        
        return answer;
    }
}