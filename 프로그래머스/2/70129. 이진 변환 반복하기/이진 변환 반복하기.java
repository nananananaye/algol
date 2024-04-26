import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int k =0;
        int zero=0;
        while(!s.equals("1")){
            // 1 갯수 찾기
            
            int cnt = 0;
            for(int i =0; i < s.length(); i++){
                if(s.charAt(i)=='1') cnt++;
            }
            zero+= (s.length()-cnt);
            System.out.println(s+" "+cnt+" "+Integer.toBinaryString(cnt));
            // 길이에 맞는 이진수로 구하기
         
            s= ""+ Integer.toBinaryString(cnt);
            k++;
        }
        answer[0] = k;
        answer[1] = zero;
        return answer;
    }
}