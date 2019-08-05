package ¹æ¹øÈ£1475;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] number = {1,1,1,1,1,1,1,1,1,1};
		int set = 1;
		for(int i =0; n >0 ; i++) {
			int x = n%10;
			n=n/10;
			if(number[x]==0) {
				if((x==6 && number[9]>0)||(x==9 && number[6]>0)) {
					if(x==6) {
						number[x]++;
						number[9]--;
					}else {
						number[x]++;
						number[6]--;
					}
				}else {
					set++;
					for(int j = 0; j<10;j++) {
						number[j]++;
					}
				}
			}
			number[x]--;
		}
		
		System.out.println(set);
	}

}
