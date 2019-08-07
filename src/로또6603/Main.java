package ·Î¶Ç6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[] number;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(1==1) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			k = Integer.parseInt(st.nextToken());
			if(k==0) {
				return;
			}
			number = new int[k];
			int[] result = new int[6];
			for(int i = 0 ; i<k ; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			fun(0,0,0,result);//ÃÑ °¹¼ö k , ½ÃÀÛ 0 , »Ì¾Æ¾ßÇÏ´Â ¼ö  0
			System.out.println();
		}
		
	}

	private static void fun(int end, int i,int index, int[] result) {
		// TODO Auto-generated method stub
		if(index==6) {
			print(result);
		}else if(end==k) {
			return;
		}
		else {
			//int x = number[i];
			
			result[index]=number[i];
			fun(end+1,i+1,index+1,result);
			fun(end+1,i+1,index,result);
		}
	}
	public static void print(int[] result) {
		for(int i = 0 ; i<6 ; i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
}
