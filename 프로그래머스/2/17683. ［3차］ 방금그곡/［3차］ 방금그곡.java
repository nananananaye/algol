import java.util.*;
class Solution {
    static List<String> M;
    static String answer; 
    static int maxTime;
    public String solution(String m, String[] musicinfos) {
        answer = "";
        maxTime = 0;
        M = findMelody(m);
     //   System.out.println("네오가 기억한 부분"+Arrays.toString(M.toArray()));
        for(String mu  : musicinfos){
            String[] music = mu.split(",");
            int time = timeToMinute(music[0],music[1]);
           // System.out.println(time);
            List<String> melody = findMelody(music[3]);         
          //  System.out.println(Arrays.toString(melody.toArray()));
            //for문으로 melody 한글자씩 보면서 M[0]이랑 같으면 탐색 시작
            for(int i = 0 ; i < melody.size();i++){
                if(!M.get(0).equals(melody.get(i))) continue;
           //     System.out.println(i+"번째에서 같음");
                boolean flag = isSame(melody,time,i);
            //    System.out.println(flag);
                if(flag){
                    if(answer.length() == 0){
                        answer = music[2];
                        maxTime = time;
                    }else{
                        if(maxTime <time){
                            answer= music[2];
                            maxTime = time;
                        }
                    }
                    break;
                }
            }
        }
        if(answer.length() == 0) answer = "(None)";
        return answer;
    }
    public boolean isSame(List<String> melody, int time, int startPoint){
        boolean res = true;
        int len = melody.size();
        if(M.size() > time) return false;
        for(int i = 0 ; i < M.size(); i ++){
            if((i+startPoint) >= time){
                res = false;
                break;
            }
          //  System.out.println((i+startPoint)%len +" "+M.get(i) +" "+ melody.get((i+startPoint)%len) );
            if(!M.get(i).equals(melody.get((i+startPoint)%len))){
                res = false;
                break;
            }
            
        }
        return res;
    }
    public List<String> findMelody(String s ){
        List<String> res = new ArrayList<>();
        int ind = 0;
        while(ind < s.length()){
            if(ind+1 <s.length() && s.charAt(ind+1) == '#'){
                res.add((""+s.charAt(ind)+"#"));
                ind +=2;
            }else{
                res.add(""+s.charAt(ind));
                ind++;
            }
        }
        return res;
    }
    public int timeToMinute(String a, String b){
        return (Integer.parseInt(b.substring(0,2))*60+Integer.parseInt(b.substring(3,5)))-(Integer.parseInt(a.substring(0,2))*60+Integer.parseInt(a.substring(3,5)));
    }
    
}