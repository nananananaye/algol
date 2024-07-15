import java.util.*;
import java.io.*;

class Main {
    static int V,E,K;
    static boolean[] visit;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node{
        int ind;
        int w;
        public Node(int ind, int w){
            this.ind = ind;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        visit= new boolean[V+1];
        graph = new ArrayList<>();
        for(int i = 0 ; i < V+1 ; i++){
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i< E ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            
        }

        PriorityQueue<Node> pq= new PriorityQueue<Node>((o1,o2)-> Integer.compare(o1.w,o2.w) );
        pq.offer(new Node(K,0));
        dist[K]=0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.ind] < cur.w) continue;

            for(int i = 0; i < graph.get(cur.ind).size();i++){
                Node next = graph.get(cur.ind).get(i);
                if(dist[next.ind] > cur.w + next.w){
                    dist[next.ind] = cur.w + next.w;
                    pq.offer(new Node(next.ind , dist[next.ind]));
                }
            }
            
            
        }
        for(int i=1;i<V+1;i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
        
        
    }
}