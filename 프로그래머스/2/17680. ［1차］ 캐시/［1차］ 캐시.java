import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        if(cacheSize==0){
            return 5*cities.length;
        }
        for(String city : cities){
           // if(q.size() < cacheSize){
            String now = city.toLowerCase();
           // System.out.println(now + " "+ q.size());
            if(q.size() == 0){
                q.offer(now);
                answer+=5;
               // System.out.println(answer);
                continue;
            }
            int size = q.size();
            boolean flag = false;
            for(int i=0 ; i < size; i++){
                String next = q.poll();
                if(now.equals(next)){
                    flag = true;
                }else{
                    q.offer(next);
                }
            }
            q.offer(now);
            if(flag){
                answer++;
            }else{
                answer +=5;
            }
            if(q.size() >cacheSize){
                q.poll();
            }
           // System.out.println(answer);
        }
        return answer;
    }
   
}