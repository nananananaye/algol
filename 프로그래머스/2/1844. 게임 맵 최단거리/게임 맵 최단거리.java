import java.util.*;
class Solution {
    static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
    static int N,M;
    public int solution(int[][] arr) {
        int answer = 0;
        N = arr.length;
        M = arr[0].length;
        Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {0,0,0});
		arr[0][0]=2;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N-1 && cur[1] == M-1) break;
			for(int d= 0 ; d <4; d++) {
				int nx = cur[0]+ dx[d];
				int ny = cur[1] + dy[d];
				if(!check(nx,ny)) continue;
				if(arr[nx][ny] != 1) continue;
				q.offer(new int[] {nx,ny});
				arr[nx][ny]= arr[cur[0]][cur[1]]+1;
			}
		}
        // for(int i = 0 ; i < N ; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        if(arr[N-1][M-1] == 1 ) return -1;
        else return arr[N-1][M-1]-1;
       // return answer;
    }
    static boolean check(int x, int y) {
		return 0<= x && x < N && 0<= y && y <M;
	}
}