package 캥거루세마리2965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int cang1 = Integer.parseInt(st.nextToken());
		int cang2 = Integer.parseInt(st.nextToken());
		int cang3 = Integer.parseInt(st.nextToken());
		
		//jump(cang1,cang2,cang3);
		int jump1 = cang3-cang2;
		int jump2 = cang2-cang1;
		if(jump1>jump2) {
			System.out.println(jump1-1);
		}else {
			
			System.out.println(jump2-1);
		}
	}

//	private static void jump(int cang1, int cang2, int cang3) {
//		// TODO Auto-generated method stub
//		
//		if((cang2-cang1)
//		
//		for(int i =0 ; i <cang3-cang2; i++) {
//			lefetjump(cang1,cang2,cang3);
//		}
//		
//		
//	}

}
