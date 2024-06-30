import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,H,min=Integer.MAX_VALUE,num=0;
    static int[] s;
    static int[] j;
    static int[] res;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        s = new int[H+2];
        j = new int[H+2];
        res = new int[H+1];
        for(int i=0; i < N ;i++){
            int x = Integer.parseInt(br.readLine());
            if(i%2 == 0){
                //석순
                s[x]++;
            }else{
                j[x]++;
            }
        }
        for(int i = H;i>0;i--){
            s[i] += s[i+1];
            j[i] += j[i+1];
            res[i]+= s[i];
            res[H+1-i] += j[i];
        }
        
        //System.out.println(Arrays.toString(res));
        for(int i = 1; i < H+1;i++){
            if(res[i] < min){
                num=1;
                min = res[i];
            }else if(res[i] == min){
                num++;
            }
        }
        System.out.println(min+" "+ num);
        
    }
}