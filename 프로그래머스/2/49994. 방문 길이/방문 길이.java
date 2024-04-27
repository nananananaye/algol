import java.util.*;
class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String dirs) {
        int answer =0;
        int[][] arr= new int[10][10];
        int x = 5;
        int y = 5;
        int d= 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < dirs.length();i++){
            if(dirs.charAt(i) == 'U'){d=0; }
            else if(dirs.charAt(i) == 'R'){ d=1;}
            else if(dirs.charAt(i) == 'D'){ d=2;}
            else if(dirs.charAt(i)== 'L'){ d=3;}
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!check(nx,ny))continue;
           // System.out.println(nx+" "+ ny + (""+x+y+nx+ny));
            if(map.containsKey((""+x+y+nx+ny)) || map.containsKey((""+nx+ny+x+y))){
                System.out.println("yes");
            }else{
                map.put((""+x+y+nx+ny),1);
                answer++;
            }
            x = nx; y = ny;
            }
        return answer;
    
    }
    public boolean check(int x , int y){
        return 0<= x && x <= 10 && 0<= y && y<= 10;
    }
}