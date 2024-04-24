import java.io.*;
import java.util.*;
class Solution {
    public class hw implements Comparable<hw>{
        String name;
        int start;
        int playtime;
        
        public hw(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        public int compareTo(hw o){
            return this.start-o.start;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> ans = new LinkedList<>();
        List<hw> list = new LinkedList<>();
        Stack<hw> pause = new Stack<>();
        Queue<hw> q = new LinkedList<>();
        //타임테이블 정리
        for(String[] plan : plans){
            int s = Integer.parseInt(plan[1].substring(0,2))*60 + Integer.parseInt(plan[1].substring(3,5));
            int p = Integer.parseInt(plan[2]);
            list.add(new hw(plan[0],s,p));
        }
        Collections.sort(list);
        for(hw h : list){
       //    System.out.println(h.name +" "+h.start+" "+h.playtime);
            q.offer(h);
        }
       // System.out.println("=시작=========");
        //시작
        while(!q.isEmpty()){
            hw cur = q.poll();
        //    System.out.println("cur = "+ cur.name );
            if(q.isEmpty()){
                ans.add(cur.name);
                break;
            }
            hw next = q.peek();
            if(cur.start+cur.playtime == next.start){ //시간이 딱 맞으면
          //      System.out.println("시간 딱 맞음");
                // 끝내기
                ans.add(cur.name);
            }else if(cur.start+cur.playtime > next.start){ //시간이 초과되면 
                // 짧게라도 한 시간 cur에 반영하고 pause에 넣어두기
           //     System.out.println("시간 초과되면 " + (cur.playtime- next.start+cur.start));
                cur.playtime -= (next.start-cur.start);
                
                pause.push(cur);
            }else{
                //여유 시간이 생기면
               // System.out.println("여유 시간 "+ (next.start - (cur.start + cur.playtime)) +"생김");
                ans.add(cur.name);
                int spare = next.start - (cur.start + cur.playtime);
                while(!pause.isEmpty()){
                    hw sparetop = pause.pop();
                    if(sparetop.playtime <= spare){ // 남는 시간이 해야할시간보다 더 많으면
                        ans.add(sparetop.name);
                        spare -= sparetop.playtime;
                    }else{ // 해야할 시간이 남는 시간보다 크면 
                        sparetop.playtime -= spare;
                        pause.push(sparetop);
                        break;
                    }
                }
            }
//             System.out.println("한차례 후 결과");
//             for(String a : ans){
//                 System.out.println(a);
//             }
//             System.out.println("_________");
                
        }
        while(!pause.isEmpty()){
            hw h = pause.pop();
            ans.add(h.name);
        }
//         System.out.println("최종 결과");
//             for(String a : ans){
//                 System.out.println(a);
//             }
//             System.out.println("=====");
              
        for(int i = 0 ; i < plans.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}