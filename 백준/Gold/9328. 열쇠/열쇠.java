import java.util.*;
import java.io.*;

public class Main {
	static int T,N, M,answer;
	static char[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static HashMap<Character, Integer> keys;
	static class Node{
		char alphabet;
		int x; 
		int y;
		public Node(char alphabet, int x, int y) {
			super();
			this.alphabet = alphabet;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [name=" + alphabet + ", x=" + x + ", y=" + y + "]";
		}
		
	}
	static List<Node> doors;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			arr =new char[N][M];
			Queue<int[]> q = new LinkedList<>();
			keys = new HashMap<>();
			doors = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				arr[i] = s.toCharArray();
			}
			String ks = br.readLine();
			if(ks != "0") {
				getKeys(ks);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
						if(i==0 || i == N-1 || j== 0 || j == M-1) {
							if(arr[i][j] == '*') {
								continue;
							}else if(arr[i][j] =='.') {
								q.offer(new int[] {i,j});
								arr[i][j] = '1';
							}else if(arr[i][j] == '$') {
								answer++;
							//	System.out.println("$$$"+i+" "+j);
								q.offer(new int[] {i,j});
								arr[i][j]= '1';
							}else if(Character.isUpperCase(arr[i][j])){
							//	System.out.println("@@"+arr[i][j]);
								if(canOpen(i,j)) {
									q.offer(new int[] {i,j});
									arr[i][j]= '1';
								//	System.out.println(i+" "+j+"can open");
								}else {
									// 다시 보기
								//	System.out.println("Cant open!");
									doors.add(new Node(arr[i][j],i,j));
								}
								
							}else if(Character.isLowerCase(arr[i][j])){
								
								for(Node door: doors) {
								//	System.out.println(Character.toLowerCase(door.alphabet)+" "+arr[i][j]+" "+(Character.toLowerCase(door.alphabet) == arr[i][j]) );
									if(Character.toLowerCase(door.alphabet) == arr[i][j]) {
										//지금 주운 키랑 doors랑 맞으면
									//	System.out.println("can open");
										q.offer(new int[] {door.x,door.y});
										arr[door.x][door.y]='1';
									}
								}
								keys.put(arr[i][j], 1);
								q.offer(new int[] {i,j});
								arr[i][j]= '1';
							} 
						}
					}
				}
			
			//System.out.println(keys.keySet());
			//System.out.println("while start");
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				//System.out.println(Arrays.toString(cur)+" "+arr[cur[0]][cur[1]]);
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!check(nx,ny)) continue;
					if(arr[nx][ny] == '*' || arr[nx][ny] == '1') continue;
					if(arr[nx][ny]== '$') {
						answer ++;
					//	System.out.println("$$$"+nx+" "+ny);
						q.offer(new int[] {nx,ny});
						arr[nx][ny]= '1';
					}else if(arr[nx][ny] == '.') {
						q.offer(new int[] {nx,ny});
						arr[nx][ny] = '1';
					}else if(Character.isLowerCase(arr[nx][ny])) {
				//		System.out.println("lower"+nx+" "+ny);
						
						for(Node door: doors) {
							if(Character.toLowerCase(door.alphabet) == arr[nx][ny]) {
								//지금 주운 키랑 doors랑 맞으면
								q.offer(new int[] {door.x,door.y});
								arr[door.x][door.y]='1';
							}
						}
						keys.put(arr[nx][ny], 1);
						q.offer(new int[] {nx,ny});
						arr[nx][ny] = '1';
					}else if(Character.isUpperCase(arr[nx][ny])) {
						//왔는데 문이면 
						if(canOpen(nx,ny)) {	
							q.offer(new int[] {nx,ny});
							arr[nx][ny]= '1';
						}else {
							// 다시 보기
							doors.add(new Node(arr[nx][ny],nx,ny));
						}
					}
				}
			}
			
			System.out.println(answer);
		}
	}
	
	static boolean canOpen(int x, int y) { // 문 왔을때 
		//System.out.println("canopen function");
		for(Character key : keys.keySet()) {
		//	System.out.println(key);
			if(Character.toUpperCase(key) == arr[x][y]) {
				return true;
			}
		}
		return false;
	}
	static void getKeys(String ks) {
		char[] kc = ks.toCharArray();
		for(char k : kc) {
			keys.put(k,1);
		}
	}
	static boolean check(int x , int y) {
		return 0<= x && x < N && 0<= y && y< M;
	}

}