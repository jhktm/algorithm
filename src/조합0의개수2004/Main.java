package 조합0의개수2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m,sum=0;
	static int[] number,result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int sumN=1;
		int sumM=1;
		
		for(int i =1 ; i<n+1 ; i++) {
			sumN *=i;
		}
		
		for(int i =1 ; i<n+1 ; i++) {
			sumM *=i;
		}
	}
	
}
