import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < progresses.length; i++){
            if(((100-progresses[i])/speeds[i]) *speeds[i] == (100-progresses[i]) ){
                q.add(((100-progresses[i])/speeds[i]));
            }else{
               q.add(((100-progresses[i])/speeds[i])+1);
            }
            }
        while(!q.isEmpty()){
            Integer cur = q.poll();
            int cnt = 1;
            //System.out.println(cur);
            while(!q.isEmpty()){
                if(cur< q.peek()){
                    break;
                }else{
                    cnt++;
                    q.poll();
                }
            }
            ans.add(cnt);
        }
        answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}