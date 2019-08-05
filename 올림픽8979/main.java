package ¿Ã¸²ÇÈ8979;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int target = scanner.nextInt();
		int[][] medal = new int[n+1][3];
		for(int i=0 ; i<n ; i++) {
			int nation = scanner.nextInt();
			int gold = scanner.nextInt();
			int siver = scanner.nextInt();
			int bronze = scanner.nextInt();
			medal[nation][0] = gold;
			medal[nation][1] = siver;
			medal[nation][2] = bronze;
		}
		int result = 1;
		for(int i=1 ; i<=n ; i++) {
			if(medal[target][0] < medal[i][0]) {
				result++;
			}else if(medal[target][0] == medal[i][0]){
				if(medal[target][1]<medal[i][1]) {
					result++;
				}else if(medal[target][1]==medal[i][1]){
					if(medal[target][2]<medal[i][2]) {
						result++;
					}
				}else {
					
				}
			}else {
			}
		}
		System.out.println(result);
	}

}
