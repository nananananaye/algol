import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        List<String[] > list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        for(String rec : record){
            String[] arr = rec.split(" ");
            if(arr[0].equals("Enter")){
                map.put(arr[1],arr[2]);
                list.add(new String[] {arr[1],"님이 들어왔습니다."});
            }else if(arr[0].equals("Leave")){
                list.add(new String[] {arr[1],"님이 나갔습니다."});
            }else{
                map.put(arr[1],arr[2]);
            }
        }
        answer = new String[list.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        }
        
        return answer;
    }
}