package ¹®ÀÚ¿­1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int sum = 100;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		
		if(s1.length() == s2.length()) {
			print(s1,s2);
		}
		else {
			int diff = s2.length()-s1.length();
			for(int i = 0 ; i<=diff;i++) {
				String tmp = s2;
				tmp = tmp.substring(0,i)+s1+tmp.substring(i+s1.length());
				print(tmp,s2);
			}
		}
		System.out.println(sum);
		
	}
	public static void print(String a, String b) {
		int d = 0;
		for(int i = 0; i<a.length();i++) {
			if((a.charAt(i))!=(b.charAt(i))){
				d++;
			}
		}
		if(d<sum) {
			sum=d;
		}
	}
}
