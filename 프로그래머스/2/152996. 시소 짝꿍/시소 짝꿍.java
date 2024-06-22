import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double,Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for(int x : weights){
            double a = x / 2.0;
            double b = x * 2.0 / 3.0;
            double c = x * 3.0 / 4.0;
            double d = x * 1.0;
            if(map.containsKey(a)){ 
                answer += map.get(a);  
            }
            if(map.containsKey(b)){ 
                answer += map.get(b);  
            }
            if(map.containsKey(c)){ 
                answer += map.get(c);  
            }
            if(map.containsKey(d)){ 
                answer += map.get(d);  
            }
            
    		map.put((x*1.0), map.getOrDefault((x*1.0), 0)+1);
            
        }
        return answer;
    }
}