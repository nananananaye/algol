import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville){
            pq.offer(x);
        }
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(first>=K){
                break;
            }
            if(pq.isEmpty()){
                answer= -1;
                break;
            }
            int second = pq.poll();
            int tmp = first+ second*2;
            pq.offer(tmp);
            answer++;
        }
        return answer;
    }
}