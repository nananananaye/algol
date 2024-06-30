import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M,now=0;
    static int[] arr,height;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        height = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < 1+N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            height[a] += c;
            height[b+1] += c*-1;
        }
        
        for(int i=1;i<N+1; i++){
            now += height[i];
            height[i] = now;
            arr[i] += height[i];
            System.out.print(arr[i]+" ");
        }
        
        
        
    }
}