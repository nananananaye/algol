import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, Comparator.comparingInt((int[] o) -> o[col-1]).thenComparing(Comparator.comparingInt((int[] o)->o[0]).reversed()));  
        for(int i = row_begin ; i < row_end+1;i++){
            int res = 0 ;
            for(int j = 0 ; j < data[i-1].length;j++){
                res += (data[i-1][j]%i);
            }
            answer = answer ^ res;
        }
        return answer;
    }
}