package test01;

import java.util.Scanner;

public class bj2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();		
		int bongji = 0;				
		
		if(n/5>=0){
			bongji += n/5;
			n= n%5;				
			if(n%3==0) {
				bongji += n/3;	
			}else {
				if(bongji==0) {
					System.out.print("-1");
					return ;
				}
				bongji = bongji-1;
				n = n+5;
				if(n%3==0) {
					bongji += n/3;
				}else {
					if(bongji==0) {
						System.out.print("-1");
						return ;
					}
					bongji = bongji-1;
					n = n+5;
					if(n%3==0) {
						bongji += n/3;
					}else {
						System.out.print("-1");
						return ;
						
					}
				}
			}
		}	
		System.out.println(bongji);		
	}

}
