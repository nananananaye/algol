//음의 가중치 x , 한노드 -> 모든 노드까지 최단거리
// int[] , ArrayList, PriorityQueue
import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        List<int[]>[] al = new ArrayList[N+1];
        Arrays.fill(dist,500001);
        for(int i=1; i < N+1;i++){
            al[i]= new ArrayList<>();
        }
        for(int[] r:road){
            al[r[0]].add(new int[] {r[1],r[2]});
            al[r[1]].add(new int[] {r[0],r[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o)-> o[1]));
        pq.offer(new int[] {1,0});
        dist[1]=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(dist[cur[0]] < cur[1]) continue;
            
            for(int[] next: al[cur[0]]){
                if(dist[cur[0]]+next[1]   <dist[next[0]]){
                    dist[next[0]] = dist[cur[0]]+next[1];
                    pq.offer(new int[] {next[0],dist[next[0]]});
                }
            }
        }
        for(int i=1; i < dist.length;i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }
}