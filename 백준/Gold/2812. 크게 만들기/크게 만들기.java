import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static String s,ans ; 
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		s = br.readLine();
		char[] c = s.toCharArray();
		arr = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			arr[i] = c[i]-'0';
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < c.length; i++) {
			if(K<=0) {
				stack.push(arr[i]);
			}else {
				if(stack.isEmpty()) {
					stack.push(arr[i]);
				}else {
					while(!stack.isEmpty() && K > 0) {
						if(stack.peek() < arr[i]) {
							stack.pop();
							K--;
						}else {
							break;
						}
					}
					stack.push(arr[i]);
				}
			}
		}
		while(K>0) {
			stack.pop();
			K--;
		}
		 while(!stack.isEmpty()){
	            sb.append(stack.pop());
	        }

	        System.out.println(sb.reverse().toString());
	
		
	}

}