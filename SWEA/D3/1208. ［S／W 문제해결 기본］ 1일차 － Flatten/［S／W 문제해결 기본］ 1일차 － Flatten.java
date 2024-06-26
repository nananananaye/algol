import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        for(int t=1; t<11; t++){
            int answer = 0;
            int[] arr = new int[100];
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0 ; x<100 ;x++ ){
                arr[x] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for(int i=0 ; i < dump;i++){
                arr[0]++;
                arr[99]--;
                int j=1;
                while(arr[0]> arr[j]){
                    j++;
                }
                int tmp = arr[--j];
                arr[j] = arr[0];
                arr[0] = tmp;

                int k = 98;
                while(arr[k] > arr[99]){
                    k--;
                }
                int tmp2 = arr[++k];
                arr[k] = arr[99];
                arr[99] = tmp2;
                
            }
           //  System.out.println(Arrays.toString(arr));
            answer = arr[99]-arr[0];
            System.out.println("#"+ t+" "+answer);
        }
        
    }
}