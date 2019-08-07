package 테트로미노14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper;
	static int n,m;
	static int sum=0;
	static int temp=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n =   Integer.parseInt(st.nextToken());
		m =   Integer.parseInt(st.nextToken());
		
		paper = new int[n+6][m+6];
		for(int i=0;i<n+6;i++) {
			for(int j=0;j<m+6;j++) {
				paper[i][j]=-1;
			}
		}
		
		for(int i=3;i<n+3;i++) {
			s=br.readLine();
			st = new StringTokenizer(s);
			for(int j=3;j<m+3;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=3;i<n+3;i++) {
			for(int j=3;j<m+3;j++) {
				check(i,j);
			}
		}
		System.out.println(sum);
		
	}
	
	private static void check(int i, int j) {
		// TODO Auto-generated method stub
		
		// 5가지를 확인해 보기
		check1(i,j); 
		check2(i,j);
		check3(i,j);
		check4(i,j);
		check5(i,j);
		
	}

	private static void check5(int i, int j) {
		// TODO Auto-generated method stub
		if(paper[i][j+1]>0&&paper[i][j+2]>0&&paper[i+1][j+1]>0) {
			temp = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1];
		}
		sum();
		if(paper[i][j-1]>0&&paper[i][j-2]>0&&paper[i-1][j-1]>0) {
			temp = paper[i][j]+paper[i][j-1]+paper[i][j-2]+paper[i-1][j-1];
		}
		sum();
		if(paper[i+1][j]>0&&paper[i+2][j]>0&&paper[i+1][j+1]>0) {
			temp = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+1][j+1];
		}
		sum();
		if(paper[i-1][j]>0&&paper[i-2][j]>0&&paper[i-1][j-1]>0) {
			temp = paper[i][j]+paper[i-1][j]+paper[i-2][j]+paper[i-1][j-1];
		}
		sum();
		
	}

	private static void check4(int i, int j) {
		// TODO Auto-generated method stub
		if(paper[i+1][j]>0&&paper[i+1][j+1]>0&&paper[i+2][j+1]>0) {
			temp = paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+2][j+1];
		}
		sum();
		if(paper[i+1][j]>0&&paper[i+1][j-1]>0&&paper[i+2][j-1]>0) {
			temp = paper[i][j]+paper[i+1][j]+paper[i+1][j-1]+paper[i+2][j-1];
		}
		sum();
		if(paper[i][j-1]>0&&paper[i+1][j-1]>0&&paper[i+1][j-2]>0) { ////
			temp = paper[i][j]+paper[i][j-1]+paper[i+1][j-1]+paper[i+1][j-2];
		}
		sum();
		if(paper[i][j+1]>0&&paper[i+1][j+1]>0&&paper[i+1][j+2]>0) {
			temp = paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j+2];
		}
		sum();
		
	}

	private static void check3(int i, int j) {
		// TODO Auto-generated method stub
		if(paper[i+1][j]>0 && paper[i+2][j]>0&&paper[i+2][j+1]>0) {
			temp = paper[i][j]+paper[i+1][j]+ paper[i+2][j]+paper[i+2][j+1];
		}
		sum();
		if(paper[i+1][j]>0 && paper[i+2][j]>0&&paper[i+2][j-1]>0) {
			temp = paper[i][j]+paper[i+1][j]+ paper[i+2][j]+paper[i+2][j-1];
		}
		sum();
		if(paper[i-1][j]>0 && paper[i-2][j]>0&&paper[i-2][j-1]>0) {
			temp = paper[i][j]+paper[i-1][j]+ paper[i-2][j]+paper[i-2][j-1];
		}
		sum();
		if(paper[i-1][j]>0 && paper[i-2][j]>0&&paper[i-2][j+1]>0) {
			temp = paper[i][j]+paper[i-1][j]+ paper[i-2][j]+paper[i-2][j+1];
		}
		sum();
		if(paper[i][j+1]>0 && paper[i][j+2]>0&&paper[i-1][j+2]>0) {
			temp = paper[i][j]+paper[i][j+1]+ paper[i][j+2]+paper[i-1][j+2];
		}
		sum();
		if(paper[i][j+1]>0 && paper[i][j+2]>0&&paper[i+1][j+2]>0) {
			temp = paper[i][j]+paper[i][j+1]+ paper[i][j+2]+paper[i+1][j+2];
		}
		sum();
		if(paper[i][j-1]>0 && paper[i][j-2]>0&&paper[i+1][j-2]>0) {
			temp = paper[i][j]+paper[i][j-1]+ paper[i][j-2]+paper[i+1][j-2];
		}
		sum();
		if(paper[i][j-1]>0 && paper[i][j-2]>0&&paper[i-1][j-2]>0) {
			temp = paper[i][j]+paper[i][j-1]+ paper[i][j-2]+paper[i-1][j-2];
		}
		sum();
	}
	private static void check2(int i, int j) {
		// TODO Auto-generated method stub
		if(paper[i][j]>0&&paper[i+1][j]>0&&paper[i][j+1]>0&&paper[i+1][j+1]>0) {
			temp = paper[i][j]+paper[i+1][j]+paper[i][j+1]+paper[i+1][j+1];
		}
		sum();
	}

	private static void check1(int i, int j) {
		// TODO Auto-generated method stub
		if(paper[i][j+1]>0&&paper[i][j+2]>0&&paper[i][j+3]>0) {
			temp = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i][j+3];
		}
		sum();
		if(paper[i+1][j]>0&&paper[i+2][j]>0&&paper[i+3][j]>0) {
			temp = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+3][j];
		}
		sum();
	}

	private static void sum() {
		// TODO Auto-generated method stub
		if(temp>sum) {
			sum=temp;
		}else {
		}
		temp = 0;
	}
}
