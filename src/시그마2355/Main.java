package ½Ã±×¸¶2355;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long A,B;
	static long SUM =0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		if(B>A) {
			long index = Math.abs((B-A+1));
			if(index%2==0){
				SUM = (A+B)*(Math.abs((B-A+1)/2));
			}else {
				SUM = (A+B)*(Math.abs((B-A+1)/2))+(A+B)/2;
			}
		}else {
			long index = Math.abs((A-B+1));
			if(index%2==0){
				SUM = (A+B)*(Math.abs((A-B+1)/2));
			}else {
				SUM = (A+B)*(Math.abs((A-B+1)/2))+(A+B)/2;
			}
		}
		
		
		System.out.println(SUM);
	}

}
