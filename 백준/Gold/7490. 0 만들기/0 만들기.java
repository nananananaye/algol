import java.io.*;
import java.util.*;

public class Main {
	
	static int T,N;
	static StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws Exception{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	T = Integer.parseInt(br.readLine());
	for (int t = 1; t < T+1; t++) {
		N = Integer.parseInt(br.readLine());
	
		dfs(1,"");
		sb.append("\n");
	}
	System.out.println(sb);
}

static void dfs(int cnt,String cal ) {
	if(cnt == N) {
		cal+=cnt;
		calculate(cal);
		return;
	}
	cal += Integer.toString(cnt);
	dfs(cnt+1, cal+" ");
	dfs(cnt+1,cal+"+");
	dfs(cnt+1,cal+"-");
	
}

static void calculate(String cal) {
	String calBefore = cal;
	cal = cal.replaceAll(" ", "");
	//System.out.println(cal);
	String a= "";
	char b = '+';
	int result = 0;
	for (int i = 0; i < cal.length(); i++) {
		//System.out.println("now"+ cal.charAt(i));
		if(cal.charAt(i) == '+' || cal.charAt(i) == '-') {
			if(b == '+') {
				result += Integer.parseInt(a);
			}else {
				result -= Integer.parseInt(a);
			}
			a= "";
			b= cal.charAt(i);
		}else {
			// 숫자면
			a += cal.charAt(i);
			if(i == cal.length()-1) {
				//마지막
				if(b == '+') {
					result += Integer.parseInt(a);
				}else {
					result -= Integer.parseInt(a);
				}
			}
		}
		//System.out.println(" res="+result+" a"+a+" b"+b);
	}
	//System.out.println("res="+result);
	if(result== 0 ) {
	//	System.out.println("dd"+calBefore);
		sb.append(calBefore+"\n");
	}
}

}