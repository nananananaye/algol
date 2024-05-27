import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] ch = skill.toCharArray();
        for(int i = 0 ; i < skill.length();i++){
            map.put(ch[i],i);
        }
        for(String x : skill_trees){
            int searchIndex = 0;
            boolean flag = true;
            for(int i= 0 ; i < x.length();i++){
                if(map.getOrDefault(x.charAt(i),-1) == -1) continue;
                if(skill.charAt(searchIndex) == x.charAt(i)){
                    searchIndex++;
                }else{
                    flag = false;
                    break;
                }
                
            }
            if(flag) answer++;
        }
        return answer;
    }
}