import java.util.*;
class Solution {
    static int[] p;
    static boolean[] v;
    static int l,K, answer = 0;
    public int solution(int k, int[][] dungeons) {
        
        p = new int[dungeons.length];
        v = new boolean[dungeons.length];
        l = dungeons.length;
        K = k;
        perm(0,dungeons);
        
        return answer;
    }
    
    public void perm(int cnt ,int[][] dungeons){
        if(cnt == l){
            go(p, dungeons);
            return;
        }
        for(int i= 0 ; i <l;i++){
            if(v[i]) continue;
            p[cnt] = i;
            v[i] = true;
            perm(cnt+1,dungeons);
            v[i]=false;
            p[cnt]=0;
            
        }
    }
    public void go(int[] p, int[][] dungeons){
        int now = K;
        int res =p.length;
        for(int i=0 ; i < p.length; i++){
            int[] dungeon = dungeons[p[i]];

            if(now < dungeon[0]){
                res = i;
                break;
            }
            now -= dungeon[1];
        }
        answer = (answer<res)? res: answer;
    }
}