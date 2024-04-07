import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        List<Integer> ans = new ArrayList<>();
        int size = genres.length;
        HashMap<String,Integer> totalPlay = new HashMap<>();
         HashMap<String,List<int[]> >  musicInfo = new HashMap<>();
        
        for(int i = 0 ; i < size ; i++){
            totalPlay.put(genres[i],totalPlay.getOrDefault(genres[i],0)+plays[i]);
            
        }
        for(String s : totalPlay.keySet()){
            List<int[]> al = new ArrayList<>();
            musicInfo.put(s, al );
        }
        
        List<String> ks = new ArrayList<>(totalPlay.keySet());
        Collections.sort(ks,(o1,o2)-> totalPlay.get(o2)- totalPlay.get(o1));
        
        for(int i = 0 ; i < size ; i++){
            musicInfo.get(genres[i]).add(new int[] {plays[i],i});
        }
        
        for(String s : ks){
     //       System.out.println(s);
            Collections.sort(musicInfo.get(s),(o1,o2)->{
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            });
            if(musicInfo.get(s).size() <2){
            for(int[] m : musicInfo.get(s)){
             //   System.out.println(Arrays.toString(m));
                ans.add(m[1]);
            }
            }else{
                int i = 0;
                for(int[] m : musicInfo.get(s)){
                    if(i>=2) break;
             //   System.out.println(Arrays.toString(m));
                    i++;
                    ans.add(m[1]);
            }
            }
        }
        answer = new int[ans.size()];
        for(int i = 0 ; i< ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}