package ÇÑ¼ö1065;

import java.io.*;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int p = 0;
		if(n<100) {
			System.out.println(n);
		}else if(n<1000) {
			int n1 =0;
			int n10=0;
			int n100=0;
			for(int i=100; i<=n;i++) {
				n100 = i/100;
				n10 = (i%100)/10;
				n1 = i%10;
				if((n1-n10)==(n10-n100)) {
					p++;
				}
			}
			System.out.println(p+99);
		}else if(n==1000) {
			int n1 =0;
			int n10=0;
			int n100=0;
			for(int i=100; i<=999;i++) {
				n100 = i/100;
				n10 = (i%100)/10;
				n1 = i%10;
				if((n1-n10)==(n10-n100)) {
					p++;
				}
			}
			System.out.println(p+99);
		}else {
			
		}
		
	}

}
