import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] ch = s.toCharArray();
        int cnt = 0;
       // System.out.println(Arrays.toString(ch));
        for(int i= 0 ; i < ch.length; i++){
            if(ch[i]=='('){
                cnt++;
            }else{
                if(cnt>=1){
                    cnt--;
                }else{
                    return false;
                }
            }
        }
        if(cnt!= 0 ) return false;
        return true;
    }
}