import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i < elements.length;i++){
            int sum =0;
            for(int x = 0 ; x < elements.length;x++){
                sum += elements[(i+x)%elements.length];
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}