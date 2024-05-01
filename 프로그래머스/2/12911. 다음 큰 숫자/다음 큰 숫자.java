class Solution {
    public int solution(int n) {
        int answer = n+1;
        int n1 = 0;
        int n2;
        String x =  Integer.toBinaryString(n);
        for(int i = 0 ; i < x.length();i++){
            if(x.charAt(i) == '1') n1++;
        }
        while(true){
            String y =  Integer.toBinaryString(answer);
            n2=0;
            for(int i = 0 ; i < y.length();i++){
            if(y.charAt(i) == '1') n2++;
            }
            if(n1==n2) break;
            answer++;
        }
        return answer;
    }
}