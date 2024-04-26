import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<int[]>[] list = new ArrayList[book_time.length];
        int[][] arr = new int[book_time.length][2];
        for(int i =0; i < book_time.length; i++){
            arr[i][0] = Integer.parseInt(book_time[i][0].substring(0,2)) *60 
                  + Integer.parseInt(book_time[i][0].substring(3,5));
            arr[i][1] = Integer.parseInt(book_time[i][1].substring(0,2)) *60 
                  + Integer.parseInt(book_time[i][1].substring(3,5));
            list[i] = new ArrayList<>();
        }
        Arrays.sort(arr,Comparator.comparingInt((int[] o)-> o[0]));
       
        int room=0;
        list[0].add(arr[0]);
        for(int i =1; i < arr.length; i++){
            boolean flag= false;
         //   System.out.println(Arrays.toString(arr[i]));
            for(int r=0; r<=room;r++){
               int fin = list[r].get(list[r].size()-1)[1]+10;
               if(fin <= arr[i][0] ){
                //   System.out.println("방안만들어두댐"+fin);
                   list[r].add(arr[i]);
                   flag = true;
                   break;
               }
           }
            if(!flag){
                list[++room].add(arr[i]);
             //   System.out.println(room+"번째 방만들어");
            }
        }
        return room+1;
    }
}