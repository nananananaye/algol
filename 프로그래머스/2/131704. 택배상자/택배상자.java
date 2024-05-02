import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i = 1; i < order.length+1;i++) q.offer(i);
        int t = 0;
        while(!q.isEmpty()){
        //    System.out.println("order[t]="+order[t]+" q.peek()="+q.peek());
            if(q.peek() == order[t]){
           //     System.out.println("같");
                q.poll();
                answer++;
                t++;
            }else{
            //    System.out.println("다");
                stack.push(q.poll());
            }
          //  System.out.println(order[t]+" "+Arrays.toString(stack.toArray()));
            while(!stack.isEmpty() ){
                if(stack.peek() !=order[t]) break;
                answer++;
                t++;
                stack.pop();
            }
        }
       
        return answer;
    }
}