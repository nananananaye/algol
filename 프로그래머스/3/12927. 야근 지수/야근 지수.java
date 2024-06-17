import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x: works){
            pq.offer(x);
        }
        while(!pq.isEmpty() && n>0){
           
            int now = pq.poll();
            if(now ==0) break;
            pq.offer(--now);
            n--;
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            answer += (x*x);
        }
        return answer;
    }
}