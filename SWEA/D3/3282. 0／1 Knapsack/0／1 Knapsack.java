import java.io.*;
import java.util.*;

public class Solution {
	static int T,N,K;
	static int[][] bags,arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bags = new int[N+1][2];
		arr= new int[N+1][K+1];
		for (int i = 1; i < N+1; i++) {
			st= new StringTokenizer(br.readLine());
			bags[i][0] = Integer.parseInt(st.nextToken());
			bags[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < 1+N; i++) {
			if(i==1) {
				for (int j = bags[i][0]; j < K+1; j++) {
					arr[i][j] = bags[i][1];
				}
			}
			for (int j = 1; j < K+1; j++) {
				if(bags[i][0] > j) {
					arr[i][j]= arr[i-1][j];
				}else {
					arr[i][j]=(arr[i-1][j]< bags[i][1]+ arr[i-1][j-bags[i][0]])?
							bags[i][1]+ arr[i-1][j-bags[i][0]]: arr[i-1][j];
				}
			}
		}
//		for (int i = 1; i < 1+N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		System.out.println("#"+t+" "+arr[N][K]);
		}
	}

}