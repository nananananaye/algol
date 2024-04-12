import java.io.*;
import java.util.*;
public class Main {
	static int V,E,answer;
	static int[] p ,r;

	static PriorityQueue<Node> pq;
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int w;
		
		public Node(int s, int e, int w) {
			this.s=s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}

		@Override
		public String toString() {
			return "Node [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		StringBuilder sb =new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		StringTokenizer st= new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		if(V== 0 && E == 0 ) break;
 		p = new int[V];
		r = new int[V];
		pq = new PriorityQueue<>();
		answer = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			answer += w;
			pq.offer(new Node(s, e, w));  
		}
		makeSet();
		int cnt = 0;
		
		while(cnt != V-1) {
			Node next = pq.poll();
		//	System.out.println(next);
			if(union(next.s,next.e)) {
				cnt++;
				answer -= next.w;
			}		
		}
		pq.clear();
		sb.append(answer+"\n");
		}

		System.out.println(sb);
		
	}
	
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x== y ) return false;
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] =y;
			
		}else {
			r[x] += r[y];
			p[y] = x;
		}
		
		return true;
	}
	
	static int find(int x) {
		if(x==p[x]) return p[x];
		else return p[x] = find(p[x]);
	}
	static void makeSet() {
		for (int i = 0; i < V; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}