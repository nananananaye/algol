import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(Integer x : tangerine){
            map.put(x, map.getOrDefault(x,0)+1);      
        }
        int[][] arr = new int[map.size()][2];
        int t = 0;
        for(Integer x : map.keySet()){
            arr[t][0] = x;
            arr[t][1] = map.get(x);
            t++;
        }
        Arrays.sort(arr,Comparator.comparingInt((int[] o) -> -o[1]));
        
        int sum=0;
        for(int i =0;i< arr.length;i++){
            sum += arr[i][1];
            if(sum>= k){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}