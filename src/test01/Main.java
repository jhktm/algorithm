package test01;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		int[] a = new int[x];
		int b = 0;
		
		for(int i =1 ; i<=x;i++) {
			int z = scanner.nextInt();
			if(y>z) {
				System.out.print(z+ " ");
			}
		}
	}
}