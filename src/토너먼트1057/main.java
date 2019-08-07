package 토너먼트1057;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int jimin= scanner.nextInt();
		int hansu= scanner.nextInt();
		
		for(int i = 0 ; i<n;i++) {
			if(jimin%2==0) {
				
			}else {
				jimin++;
			}
			if(hansu%2==0) {
				
			}else {
				hansu++;
			}
			if(jimin==hansu) {
				System.out.println(i+1);
				break;
			}else {
				jimin = jimin/2;
				hansu = hansu/2;
			}
		}
	}
}
