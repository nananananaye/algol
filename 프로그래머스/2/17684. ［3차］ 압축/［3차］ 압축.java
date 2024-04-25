import java.util.*;
class Solution {
    static HashMap<String,Integer> map = new HashMap<>();
    
    public int[] solution(String msg) {
        int[] answer;
        List<Integer> ans = new ArrayList<>();
        addDict();
        String[] arr = msg.split("");
      //  System.out.println(Arrays.toString(arr));
        int i = 0;
        int d = 27;
        while(i< arr.length){
            String w = arr[i];
           // System.out.println("지금 뽑은거="+w);
            int j =i+1;
            while(j<=arr.length-1){
               // System.out.println("이거 들었니?"+(w+arr[j]));
                if(map.containsKey(w+arr[j])){
                    w += arr[j++];
                }else{
                    map.put(w+arr[j],d++);
                    break;
                }
            }
            i=j;
           // System.out.println("w="+w);
            ans.add(map.get(w));
            
        
        }
        answer = new int[ans.size()];
        for(int j = 0 ; j<ans.size();j++){
            answer[j]= ans.get(j);
        }
        return answer;
    }
     public void addDict(){
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);
        map.put("F",6);
        map.put("G",7);
        map.put("H",8);
        map.put("I",9);
        map.put("J",10);
        map.put("K",11);
        map.put("L",12);
        map.put("M",13);
        map.put("N",14);
        map.put("O",15);
        map.put("P",16);
        map.put("Q",17);
        map.put("R",18);
        map.put("S",19);
        map.put("T",20);
        map.put("U",21);
        map.put("V",22);
        map.put("W",23);
        map.put("X",24);
        map.put("Y",25);
        map.put("Z",26);
}
}