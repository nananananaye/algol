
import java.io.*;
import java.util.*;

public class Solution {
	static int T,answer;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			answer =0;
			arr= new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i= 1; i>=0 ; i--) {
				if(arr[i] < arr[i+1]) continue;
				else if(arr[i]== arr[i+1]) {
					answer ++;
					arr[i]--;
				}else {
					answer += (arr[i]-arr[i+1]+1);
					arr[i] = arr[i+1]-1;
				}
				if(arr[i]<=0) {
					answer = -1;
					break;
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
}
