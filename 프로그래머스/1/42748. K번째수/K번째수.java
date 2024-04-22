import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0 ; i <commands.length; i++){
            int[] com = commands[i];
            int[] arr = Arrays.copyOfRange(array,com[0]-1,com[1]);
            Arrays.sort(arr);
            answer[i]= arr[com[2]-1];
        }
        return answer;
    }
}