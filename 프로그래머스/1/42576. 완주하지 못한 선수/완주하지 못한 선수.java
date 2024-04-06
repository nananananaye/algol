import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        for(String name  : participant){
            if(!hm.containsKey(name)){
                hm.put(name,1);
            }else{
                hm.put(name,hm.get(name)+1);
            }
        }
        for(String name : completion){
            hm.put(name,hm.get(name)-1);
            if(hm.get(name) <= 0 ){
                hm.remove(name);
            }
        }
        for(String name: hm.keySet()){
            answer = name;
        }
        
        return answer;
    }
}