import java.io.*;
import java.util.*;
public class Solution {
	
	static int T,N,M,K;
	static int[] people;
	static boolean answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			answer = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			people= new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				people[i] =  Integer.parseInt(st.nextToken());
			}
			Arrays.sort(people);
			//System.out.println(Arrays.toString(people));
			for (int i = 0; i < N; i++) {
				//System.out.println(people[i]/M*K+" "+i);
				if(people[i]/M*K-i <= 0) {
					answer =false;
					break;
				}
			}
			
			System.out.println("#"+t+" "+((answer)?"Possible":"Impossible"));
		}
	}

}