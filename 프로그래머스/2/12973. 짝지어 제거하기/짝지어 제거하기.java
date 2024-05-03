import java.util.*;
class Solution
{
    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i= 0; i < ch.length;i++){
            if(stack.isEmpty()) {
                stack.push(ch[i]);
                continue;
            }
            if( stack.peek() == ch[i] ) {
                stack.pop();
            }else{
                stack.push(ch[i]);
            }
        }
        System.out.println(Arrays.toString(stack.toArray()));
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}


// int answer = 0;
//         Queue<Character> q = new LinkedList<>();
//         for(int i = 0 ; i < s.length(); i++){
//             q.add(s.charAt(i));
//         }
//         while(!q.isEmpty()){
//             boolean flag = false;
//             int size = q.size();
//             int i = 0;
//             while(i<size){
//                 char now = q.poll();
             
//                 if(i== size-1 ){
//                     q.offer(now);
//                     break;
//                 }
//                 if(now == q.peek()){
//                     i++;
//                     q.poll();
//                     flag = true;
//                 }else{
//                     q.offer(now);
//                 }
//                 i++;
//             }
//             if(!flag)break;
//         }
//         if(q.size() == 0) answer = 1;
//         return answer;