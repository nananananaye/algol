import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String,Integer> timePerCar = new HashMap<>();
        HashMap<String,Integer> inPerCar = new HashMap<>();
        HashMap<String,Integer> costs = new HashMap<>();
        for(String record : records){
            String[] st = record.split(" ");
            if(st[2].equals("OUT")){
                int ttm = Integer.parseInt(st[0].substring(0,2))*60 + Integer.parseInt(st[0].substring(3,5));
                timePerCar.put(st[1],timePerCar.getOrDefault(st[1],0)+ (ttm-inPerCar.get(st[1])));
                inPerCar.remove(st[1]);
            }else{
               int ttm = Integer.parseInt(st[0].substring(0,2))*60 + Integer.parseInt(st[0].substring(3,5));
                inPerCar.put(st[1],ttm);
            }
         
        }
        for(String carNum : inPerCar.keySet()){
             timePerCar.put(carNum,timePerCar.getOrDefault(carNum,0)+ ((23*60+59)-inPerCar.get(carNum)));
        }
        for(String carNum : timePerCar.keySet()){
          //  System.out.println("cn" + carNum+" " +timePerCar.get(carNum));
            int cost = fees[1];
            double time = timePerCar.get(carNum);
            double unit = fees[2];
            
            if(timePerCar.get(carNum) <= fees[0]){
                costs.put(carNum,cost);
                continue;
            }
            time -= fees[0];
            cost += Math.ceil(time/unit)*fees[3];
            costs.put(carNum,cost);
        }
       // System.out.println(costs);
        Set<String> set = costs.keySet();
        String[] keyArr = set.toArray(new String[set.size()]);
        Arrays.sort(keyArr);
      // System.out.println(Arrays.toString(keyArr));
        answer = new int[set.size()];
        for(int i = 0 ; i < set.size();i++){
            answer[i] = costs.get(keyArr[i]);
        }
        return answer;
    }
}