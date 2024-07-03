import java.util.*;
import java.io.*;

class Solution {

    static int T,N,answer;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t < T+1 ; t++){
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr= new int[N][N];
            for(int i = 0 ; i < N;i++){
                String s = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    arr[i][j] = s.charAt(j)- '0';
                }
            }
            for( int i = 0 ; i < N/2+1 ; i++){
                for(int j = N/2-i ; j < N/2+1+i ; j++){
                    answer += arr[i][j];
                }
            }
            for( int i = N/2+1 ; i < N ; i++){
                for(int j = N/2+1-(N-i); j < N/2+(N-i) ; j++){
                    answer += arr[i][j];
                }
            }

            System.out.println("#"+t+" "+answer);
        }
    }
}