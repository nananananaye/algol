import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T+1; t++){
            int answer =0;
            String s = br.readLine();
            char[] arr = new char[s.length()];
            Arrays.fill(arr,'0');
            for(int x = 0 ; x < arr.length;x++){
                if(s.charAt(x) == arr[x]){ 
                    continue;
                }
                
                for(int y = x; y< arr.length; y++){
                    arr[y] = (arr[y] == '1')? '0':'1';
                } 
                answer++;
            }
            
            System.out.println("#"+t+" "+answer);
        }
    }
}