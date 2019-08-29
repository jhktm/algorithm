package 제곱ㄴㄴ수1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	

	static long min,max;
	static boolean[] primeList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		
		int end =  ((int) Math.sqrt(max)); // 근사값
		boolean[] checkArray = new boolean[1000001];
		Arrays.fill(checkArray, false); // 전부 false
		for(long i = 2 ; i<=end ; i++) {
			long square = i*i;
			long start = ((min-1)/square+1) * square;
			for(long a = start; a<=max ; a +=square) {
				checkArray[(int)(a-min)] = true;
			}
		}
		int count =0; // true 인것  = 겹치는거
		for(int i =0 ; i <(max-min+1); i++) {
			count +=(checkArray[i]==true)? 1:0;
		}
		System.out.println(max-min-count+1);
		
		
	}

}
