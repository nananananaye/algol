import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,Q,now=0;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        arr = new int[1000002];
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]++;
            arr[b+1]--;
        }
        
        for(int i = 1; i < 1000002;i++){
            now += arr[i];
            arr[i] =now;
        }
        
        Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q;i++){
            int x = Integer.parseInt(st.nextToken());
            System.out.println(arr[x]+" ");
        }  
        
    }
}