package ¾à¼ö1037;

import java.util.Scanner;

public class Main {
	static int N,min=0,max=1000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i =0; i<N;i++) {
			if(i==0) {
				min=sc.nextInt();
				max=min;
			}else {
				int temp = sc.nextInt();
				if(temp<min) {
					min=temp;
				}
				if(temp>max) {
					max=temp;
				}
			}
		}
		System.out.println(min*max);
		
	}
}
