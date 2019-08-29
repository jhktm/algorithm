package 리모컨1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,power=0,temp,chanel,times=0,high=0,low=9,result=1000000,sw=0,changed=0;
	static int[] buttun;
	static int[] Ndetail,Ntemp;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		
		//100일 경우 바로 리턴
		chanel = 100;
		
		if(Math.abs(N-chanel)<result) {
			result = Math.abs(N-100);
		}
		//그외 진행
		Ndetail = new int[s.length()];
		Ntemp = new int[s.length()];
		for(int i =0 ; i<s.length() ; i++) {
			Ndetail[i] = s.charAt(i)-'0';
			
		}
		
		buttun = new int[10];
		for(int i=0 ; i<10 ; i++) {
			buttun[i]=1;
		}
		
		//안되는 버튼수 입력 받기
		s = br.readLine();
		st = new StringTokenizer(s);
		M = Integer.parseInt(st.nextToken()); //갯수
		if(M != 0) {
			s = br.readLine();
			st = new StringTokenizer(s);
		}
		
		for(int i=0;i<M;i++) {
			temp = Integer.parseInt(st.nextToken());
			buttun[temp]=0;
		}
		for(int i =0 ; i<10;i++) {
			if(buttun[i]==1 && i<low) {
				low = i;
			}
			if(buttun[i]==1 && i>high) {
				high = i;
			}
		}
		
		
		//준비 됨 이제 비교 
		if(chanel == N) {
			System.out.println(0);
			return;
		}
		int zero = 0;
		for(int i =0 ; i <10 ; i++) {
			if(buttun[i]!=0) {
				zero++;
			}
		}
		if(zero==0) {
			System.out.println(Math.abs(N-100));
			return;
		}
		Ntemp = Ndetail.clone();
		
		for(int i = 0; i<Ntemp.length;i++) {
			findlow(i);
			if(changed==1) {
				break;
			}
		}
		if(sw==Ndetail.length) {
			if(sw<result) {
				System.out.println(sw);
			}else {
				System.out.println(result);
			}
			return;
		}
		sw=0;
		Ntemp = Ndetail.clone();
		changed=0;
		for(int i = 0; i<Ntemp.length;i++) {
			findhigh(i);
			if(changed==1) {
				break;
			}
		}if(sw==Ndetail.length) {
			if(sw<result) {
				System.out.println(sw);
			}else {
				System.out.println(result);
			}
		}else {
			System.out.println(result);
		}
		
	}
	
	
	
	
	
	private static void findlow(int n) { // 작게 만듬 100 ->99
		if(buttun[Ndetail[n]] == 0) {
			if(buttun[1] == 0 && Ntemp[0]==1 && N>=10) {
				Ntemp[0]=0;
			}else {
				if(Ndetail[n]==0) {
					if(n>=1) {
						if(Ntemp[n-1]==1) {
							Ntemp[n-1]=0;
						}else {
							Ntemp[n-1]= findlowN(n,Ndetail[n-1]-1); //앞자리를 바꿔야 할때
						}
					}
				}
				Ntemp[n]=findlowN(n,Ndetail[n]); // 9로 바꾸는 부분
			}
			
			for(int i =n+1 ; i<Ndetail.length;i++) {
				Ntemp[i]=high;
			}
			setresult();
			changed=1;
			
		}else {
			sw++;
		}
	}

	private static void findhigh(int n) {
		// TODO Auto-generated method stub
		if(buttun[Ndetail[n]] == 0) {
			if(Ndetail[n] == 9) {
				if(n>=1) {
					Ntemp[n-1]= findhighN(n,Ndetail[n-1]+1);
					Ntemp[n]=findhighN(n,Ndetail[n]);
				}else {
					if(buttun[1]==1) {
						power=1;
						Ntemp[0] =low;
					}
				}
			}else {
				Ntemp[n]=findhighN(n,Ndetail[n]);
			}
			for(int i =n+1 ; i<Ndetail.length;i++) {
				Ntemp[i]=low;
			}
			setresult();
			changed=1;
		}else {
			sw++;
		}
	}
	
	private static void setresult() {
		// TODO Auto-generated method stub
		int num =0;
		num = num+power;
		for(int digit:Ntemp) {
			num*=10;
			num+=digit;
		}
		int numtemp = num;
		int jari = 0;
		 do{
			jari++;
			numtemp = numtemp/10;
		}while(numtemp>0);
		//System.out.println(result+" 나온수 : "+num);
		if(Math.abs(num-N)+jari<result) {
			if(Math.abs(num-N) == 0 && buttun[0]==0) {
			}else {
				result = Math.abs(num-N)+jari;
				
			}
		}
	}
	private static int findlowN(int z ,int n) { //현재 n의 값에서 낮은 수 찾기
		// TODO Auto-generated method stub
		for(int i =n ; i>0 ; i--) {
			if(buttun[i]==1) {
				return i;
			}
		}
		if(N<10) {
			return low;
		}
		//만약 0에서 더 낮은 수를 찾는 경우에는
		if(buttun[0]==0) {
			if(z==0) {
				return 0;
			}
			if(n>=1) {
				if(Ntemp[n-1]==1) {
					Ntemp[n-1]=0;
					
				}else {
					Ntemp[n-1]= findlowN(z,Ndetail[n-1]-1); //앞자리를 바꿔야 할때
				}
			}
			return high;
		}else {
			return 0;
		}
	}
	private static int findhighN(int z,int n) {
		// TODO Auto-generated method stub
		for(int i =n ; i<10 ; i++) {
			if(buttun[i]==1) {
				return i;
			}
		}
		if(z==0) {
			if(buttun[1]==1) {
				power=1;
				Ntemp[0] =low;
			}
		}
		return 0;
	}
}
