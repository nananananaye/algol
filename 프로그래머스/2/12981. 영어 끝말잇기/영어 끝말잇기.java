import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String,Integer>map = new HashMap<>();
        String before = words[0];
        int ans = 1;
        map.put(before,1);
        boolean flag = true;
        for(int i = 1 ; i < words.length; i ++){
            if(!map.containsKey(words[i]) && before.charAt(before.length()-1) ==  words[i].charAt(0)){
                map.put(words[i],1);
                before = words[i];
            }else{
                flag = false;
                ans = i;
                break;
            }
        }
       // System.out.println(map);
       // System.out.println(ans);
        if(flag) return answer;
        if(ans <n){
            answer[0]= ans+1;
            answer[1]= 1;
        }else{
            answer[0] = ans%n +1;
            answer[1] = ans/n+1;
            }
        return answer;
    }
}