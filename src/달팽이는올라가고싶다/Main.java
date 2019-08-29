package 달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A,B,V;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		int n = A-B;
		int i = 0 ;
		if((V-A)%n>0 && (V-A)%n<n) {
			System.out.println((V-A)/n+2);
		}else {
			System.out.println((V-A)/n+1);
		}
	}

}
