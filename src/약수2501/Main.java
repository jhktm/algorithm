package ¾à¼ö2501;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int n=0;
		for(int i =1 ;i<=N ; i++) {
			if((N%i)==0) {
				n++;
				if(n==K) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(0);
	}

}
