import java.io.*;
import java.util.*;
public class Main {
	static int N,M,K, result = Integer.MAX_VALUE;
	;
	static int[][] origin,rotations,copy;
	static int[] order;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		origin =new int[N][M];
		rotations = new int[K][3];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st =new StringTokenizer(br.readLine());
			rotations[i][0] = Integer.parseInt(st.nextToken())-1;
			rotations[i][1] = Integer.parseInt(st.nextToken())-1;
			rotations[i][2] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[K];
		order = new int[K];
		perm(0);
		System.out.println(result);
}
	static void perm(int cnt) {
		//System.out.println("c="+cnt+Arrays.toString(visited));
		if(cnt == K) {
			//System.out.println(Arrays.toString(order));
			makeRotations(order);
			return;
		}
		for (int i = 0; i < K; i++) {
			if(visited[i]) continue;
			visited[i]= true;
			order[cnt]= i;
			perm(cnt+1);
			visited[i]= false;
			order[cnt]= 0;
		}
	}
	static void makeRotations(int[] order) {
		
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = origin[i].clone();
		}
		for (int turn : order) {
			rotate(rotations[turn]);
		}
		//show();
		int arrRes = calculate(copy);
		if(result > arrRes) {
			result = arrRes;
		}
		
		//System.out.println();
	}
	static int calculate(int[][] copy2) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < copy2.length; i++) {
			int sum = 0;
			for (int j = 0; j < copy2[0].length; j++) {
				sum += copy2[i][j];
			}
			if(res> sum) res = sum;
		}
		
		
		return res;
		
	}
	
	static void rotate(int[] rotateInfo) {
		int centerX = rotateInfo[0];
		int centerY = rotateInfo[1];
		int k = rotateInfo[2];
		
		for (int size = 1; size <= k; size++) {
			int startRes = copy[centerX-size][centerY-size]; //첨 값 저장 
			//왼쪽 세로
			for (int i = centerX-size; i < centerX+size; i++) {
				copy[i][centerY-size] = copy[i+1][centerY-size];
			}
			//아래
			for (int j = centerY-size; j < centerY+size; j++) {
				copy[centerX+size][j] = copy[centerX+size][j+1];

			}
			//오른쪽 세로 
			for (int i = centerX+size; i >centerX-size; i--) {
				copy[i][centerY+size] = copy[i-1][centerY+size];
			}
			//위
			for (int j = centerY+size; j >centerY-size; j--) {
				copy[centerX-size][j] = copy[centerX-size][j-1];
			}
			copy[centerX-size][centerY-size+1] = startRes;
		}
	}
	
	static void show() {
		for (int i = 0; i < N; i++) {
			
				System.out.println(Arrays.toString(copy[i]));
			
		}
		System.out.println();
	}
	
}