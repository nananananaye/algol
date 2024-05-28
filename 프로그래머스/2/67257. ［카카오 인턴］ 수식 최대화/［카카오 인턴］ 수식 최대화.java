import java.util.*;
class Solution {
    static int[] p;
    static boolean[] v;
    static long answer;
    static char[] oper = {'+','-','*'};
    static List<String> exp ; 
    public long solution(String expression) {
        answer = 0;
        p = new int[3];
        v = new boolean[3];
        exp = div(expression);
        perm(0);
        return answer;
    }
    
    public void cal(char[] priority){
      //  System.out.println(Arrays.toString(priority));
        Queue<String> q = new LinkedList<>();
        for(int i =0 ; i < exp.size();i++){
            q.offer(exp.get(i));
        }
        for(char o : priority){
            Deque<String> stack = new ArrayDeque<>();
            while(!q.isEmpty()){
                String now = q.poll();
                if(now.equals(Character.toString(o))){
                    long a = Long.parseLong(stack.removeLast());
                    long b = Long.parseLong(q.poll());
                    if(o=='+'){stack.addLast((a+b)+"");}
                    else if(o=='-'){stack.addLast((a-b)+"");}
                    else if(o=='*'){stack.addLast((a*b)+"");}
                }else{
                    stack.addLast(now);
                }
            }
           //System.out.println("stack"+ Arrays.toString(stack.toArray()));
            while(!stack.isEmpty()){
                String x = stack.removeFirst();
                q.offer(x);
            }
            
        }
         long res = Math.abs(Long.parseLong(q.poll()));
                if(answer< res){
                    answer = res;
                }
        
    }
    public void perm(int dep){
        if(dep == 3){
            char[] priority = new char[3];
        for(int i=0;i<3;i++){
            priority[p[i]]= oper[i];
            }
            cal(priority);
            return;
        }
        for(int i = 0; i < 3 ; i++){
            if(v[i]) continue;
            v[i] = true;
            p[dep] = i;
            perm(dep+1);
            v[i]=false;
        }
    }
    public List<String> div(String x){
        LinkedList<String> list = new LinkedList<>();
        String now = "";
        for(int i =0 ; i < x.length();i++){
            if(x.charAt(i) == '-' || x.charAt(i) == '*' || x.charAt(i) == '+' ){
                list.add(now);
                list.add(""+x.charAt(i));
                now = "";
            }else{
                now += x.charAt(i);
            }
        }
        list.add(now);
        return list;
    }
}