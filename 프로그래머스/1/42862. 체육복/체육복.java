import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int cnt = 0;
        int[] arr = new int[n+2];
        
        for(int x : reserve){
            arr[x] =1;
        }
        Arrays.sort(lost);
        List<Integer> lost2 = new ArrayList<>();
        for(int x : lost){
           if( arr[x] ==1){
               arr[x]=0;
           }else{
               lost2.add(x);
           }
           
        }
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lost2.toArray()));
        for(int x : lost2){
            if(arr[x-1]==1){
                cnt++;
                arr[x-1] =0;
            }else if(arr[x+1]==1){
                cnt++;
                arr[x+1]=0;
            }
        }
        return n-lost2.size()+cnt;
    }
}