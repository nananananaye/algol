class Solution {
    static boolean[] visited;
    static String[] W ;
    static String T;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        T = target;
        W = words;
        visited = new boolean[words.length];
        boolean flag = false;
        for(String word : words){
            if(word.equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        for(int i = 0; i < words.length; i++){
            if(check(begin,words[i])){ // 한글자 차이나면
              //  System.out.println(words[i]);
                visited[i] = true;
                dfs(i,visited,1);
                visited[i] = false;
            }
        }
        return (answer== Integer.MAX_VALUE)?0: answer;
    }
    public void dfs(int i, boolean[] v, int cnt){
        //System.out.println(W[i]);
        if(W[i].equals(T)){
           //System.out.println(cnt);
            answer = (answer > cnt) ? cnt: answer;
            return;
        }
        for(int x=0; x < W.length;x++){
            if(x==i) continue;
            if(check(W[i],W[x]) && !v[x]){
                v[x]=true;
                dfs(x,v,cnt+1);
                v[x]=false;
            }
        }
    }
    public boolean check(String x, String y){
        int diff = x.length();
        for(int i = 0 ; i< x.length();i++){
            if(x.charAt(i) == y.charAt(i)) diff--;
        }
        if(diff== 1) return true;
        return false;
    }
}