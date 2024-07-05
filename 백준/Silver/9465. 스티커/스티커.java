import java.util.*;
import java.io.*;

class Main {
    static int T,N;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t= 1 ; t < T+1 ; t++){
            N = Integer.parseInt(br.readLine());
            arr= new int[2][N+1];
            StringTokenizer st;
            for(int i = 0 ; i < 2; i++){
                st= new StringTokenizer(br.readLine());
                for(int j = 1 ; j < N+1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                
            }
            
            for(int i= 2 ; i < N+1;i++){
                arr[0][i] = Math.max(arr[1][i-1], arr[1][i-2])+ arr[0][i];
                arr[1][i] = Math.max(arr[0][i-1], arr[0][i-2])+ arr[1][i];
            }
            System.out.println(Math.max(arr[1][N],arr[0][N]));
        }
        
    }
}