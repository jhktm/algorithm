package °ö¼À1629;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	static long  A,B,C,D=1;
	public static void main(String[] args){
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
//		if(B==0) {
//			System.out.println(1);
//		}else {
//			D=namuji(A,B);
//			System.out.println(D);
//		}
		
		
	}
	private static long namuji(long a, long b) {
		// TODO Auto-generated method stub
		long temp = 0;
		if(b ==  1 ) {
			return a%C;
		}
		if(b%2==0) {
			temp =  namuji(a,b/2);
			return (temp*temp)%C;
		}else {
			temp = namuji(a,(b-1)/2);
			long temp2 = (temp*temp)%C;
			return (A*temp2)%C;
		}
		
	}
	

}
