package Z1074��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//���� ó�� Ǯ��� ������ ���� ���� ��������� //
	static int N,r,c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int n = getSize(N);
		int count = 0;
		int x = 0;
		int y = 0;
		
		/**
         * �簢�� �������� ������ �� ��и����� ���
         * n�� 1�� �ȴٴ� ���� x, y ��ǥ�� r, c�� �������ٴ� ��
         */
		while(n>0) {
			n/=2;
			if(r<x+n && c< y+n) {
				count+=n*n*0;
			}else if(r<x+n) {
				count+=n*n*1;
				y+=n;
			}else if(c<y+n) {
				count+=n*n*2;
				x+=n;
			}else {
				count +=n*n*3;
				x+=n;
				y+=n;
			}
			if(n==1) {
				System.out.println(count);
				break;
			}
		}
	
	}
	private static int getSize(int n) {
		// TODO Auto-generated method stub
		int result = 1;
		for(int i =0;i<n;i++) {
			result *=2;
		}
		return result;
	}
	
}
