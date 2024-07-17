import java.util.*;
import java.io.*;

class Main {
    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    static int N,M;
    static int[] dist;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int [N+1];
        visit = new boolean[N+1];
        List<List<Node>> graph = new ArrayList<>();
        for(int i =0 ; i < N+1; i++){
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i < M+1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.w,o2.w));
        pq.offer(new Node(1,0));
        dist[1] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            //System.out.println("cur = "+cur.v+" "+cur.w);
            if(visit[cur.v] || dist[cur.v] < cur.w ) continue;
            visit[cur.v] = true;
            for(int i=0;i<graph.get(cur.v).size();i++){
                Node next = graph.get(cur.v).get(i);
                //System.out.println("   next = "+next.v+" "+next.w);
                if( dist[next.v] > dist[cur.v] + next.w){
                    dist[next.v] = dist[cur.v] +next.w;
                    pq.offer(new Node(next.v,dist[next.v]));
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
        System.out.println(dist[N]);
    }
}