import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        map1.put(topping[0],1);
        for(int i = 1; i< topping.length;i++){
            map2.put(topping[i],map2.getOrDefault(topping[i],0)+1);
        }
        
        if(map1.size() == map2.size())answer++;
        for(int k=1; k< topping.length-1;k++){
            map1.put(topping[k],map1.getOrDefault(topping[k],0)+1);
            map2.put(topping[k],map2.get(topping[k])-1);
            if(map2.get(topping[k])<=0){
                map2.remove(topping[k]);
            }
            if(map1.size() == map2.size())answer++;
        }
        return answer;
    }
}