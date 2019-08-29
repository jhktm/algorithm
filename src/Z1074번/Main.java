package Z1074번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//스택 처럼 풀어보기 마지막 지점 부터 재귀적으로 //
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
         * 사각형 절반으로 나눠서 각 사분면으로 계산
         * n이 1이 된다는 것은 x, y 좌표가 r, c랑 같아진다는 것
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
