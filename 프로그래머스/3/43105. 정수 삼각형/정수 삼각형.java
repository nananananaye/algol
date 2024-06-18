import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr=  new int[triangle.length+1][triangle.length+1];
        arr[1][1]=triangle[0][0];
        if(triangle.length == 1){
            return triangle[0][0];
        }
        for(int i=2;i<triangle.length+1;i++){
            for(int j = 1; j < triangle.length+1;j++){
                if(i<j) break;
                arr[i][j] = (arr[i-1][j-1] > arr[i-1][j])? triangle[i-1][j-1]+  arr[i-1][j-1] :triangle[i-1][j-1]+  arr[i-1][j]; 
            }
        //    System.out.println(Arrays.toString(arr[i]));
        }
        
        for(int i = 1; i < arr.length; i++){
            answer = Math.max(answer, arr[arr.length-1][i]);
        }
        return answer;
    }
}