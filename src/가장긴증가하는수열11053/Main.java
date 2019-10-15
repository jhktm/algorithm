package 가장긴증가하는수열11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;
public class Main {

	static int A,MAX = 0;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		A = Integer.parseInt(st.nextToken());
		dp = new int[A][2]; // 0 length 1 max
		s = br.readLine();
		st = new StringTokenizer(s);
		for(int i = 0 ; i<A ; i++) {
			dp[i][0] = 1; //시작 할때는 길이가 1
			//시작 할때는 지금거가 최대
			dp[i][1] = Integer.parseInt(st.nextToken());
			for(int j =0 ; j<i ; j++) {
				if(dp[j][1]<dp[i][1]) // 현재 값보다 작다면
					dp[i][0] = Math.max(dp[i][0],dp[j][0]+1);
				//길이를 다시 채워준다.
			}
			MAX = MAX < dp[i][0] ? dp[i][0] : MAX;
		}
		
		System.out.println(MAX);
	}
}
