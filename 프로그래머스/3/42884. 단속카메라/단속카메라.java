import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,Comparator.comparingInt(o->o[0]));
        // for(int [] r : routes){
        //     System.out.println(Arrays.toString(r));
        // }
        int start = -30001;
        int end = -30001;
        for(int i = 0 ; i < routes.length;i++){
            if(end < routes[i][0] ){
                answer++;
                start = routes[i][0];
                end = routes[i][1];
            }else{
                if(start < routes[i][0]){ start = routes[i][0];}
                if(end > routes[i][1]){ end = routes[i][1]; }
            }
          //  System.out.println(start+" "+end);
        }
        
        return answer;
    }
}