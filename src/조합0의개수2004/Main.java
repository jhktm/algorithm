package ����0�ǰ���2004;

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
		
		//���ڸ��� 0 �� ���� = 2^N 5^M �� ���� ���� 0�� �� �� �̴�.
		int two=0,five=0;
		int twotemp=2,fivetemp=5;
		int twomax;
		int k=1;
		while(twotemp<=n) {
		
			two +=n/twotemp;
			two -=m/twotemp;
			two -=(n-m)/twotemp;
			k++;
			twotemp=(int)Math.pow(2, k);
		}
		k=1;
		while(fivetemp<=n) {
			five +=n/fivetemp;
			five -=m/fivetemp;
			five -=(n-m)/fivetemp;
			k++;
			fivetemp=(int)Math.pow(5, k);
		}
		
		if(two>=five) {
			System.out.println(five);
		}else {
			System.out.println(two);
			
		}
	}
	
}
