import java.io.*;
import java.util.*;
public class Solution {
	static int T,N,sx,sy,ex,ey,answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = false;
				}
				//System.out.println(Arrays.toString(arr[i]));
			}
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			// 입력
			
			q.add(new int[] {sx,sy});
			visited[sx][sy] = true;
			int time =1;
			loop:
			while(true) {
				if(q.isEmpty()) break;
				int size = q.size();
			//	System.out.println("size"+size);
//				for (int[] is : q) {
//					System.out.println(Arrays.toString(is));
//				}
				for (int i = 0; i < size; i++) {
					int[] cur = q.poll();
					if(cur[0] == ex && cur[1] == ey) {
					//	System.out.println("같다!!"+time);
						answer = time-1;
						break loop;
					}
					boolean flag= false;
					for (int k = 0; k < 4; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						if(!check(nx,ny)) continue;
						if(visited[nx][ny]) continue;
						if(arr[nx][ny] == 0) {
							q.offer(new int[] {nx,ny});
							visited[nx][ny] = true;
						}
						if(arr[nx][ny]== 2) {
							if(time%3 != 0) {
								flag = true;
							}else {
								q.offer(new int[] {nx,ny});
								visited[nx][ny] = true;
							}
						}
					}
					if(flag) {
						q.offer(cur);
					}
				}
				
				
				
				time++;
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
	static boolean check(int x, int y) {
		return 0<= x && x < N && 0<= y && y< N;
	}
}