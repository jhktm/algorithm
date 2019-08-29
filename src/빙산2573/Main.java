package ºù»ê2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,year=0,check=0;
	static int[][] bingsan,temp,visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bingsan = new int [n][m];
		temp =  new int [n][m];
		visited= new int [n][m];
		for(int i =0; i<n ; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for(int j=0; j<m;j++) {
				bingsan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(check==0) {
			check=melting();
			temp =  new int [n][m];
			visited= new int [n][m];
		}
	}
	private static int melting() {
		year++;
		// TODO Auto-generated method stub
		for(int i =0; i<n ; i++) {
			for(int j=0; j<m;j++) {
				if(bingsan[i][j] != 0) {
					if(bingsan[i-1][j]==0) {
						temp[i][j]++;
					}
					if(bingsan[i+1][j]==0) {
						temp[i][j]++;
					}
					if(bingsan[i][j-1]==0) {
						temp[i][j]++;
					}
					if(bingsan[i][j+1]==0) {
						temp[i][j]++;
					}
				}
			}
		}
		resultmelt();
		return check();
	}
	private static int check() {
		// TODO Auto-generated method stub
		int sw = 0;
		int chec = 0;
		for(int i =0; i<n ; i++) {
			for(int j=0; j<m;j++) {
				if(bingsan[i][j] != 0) {
					chec++;
					if(sw == 0) {
						checking(i,j);
						sw++;
					}else {
						if(visited[i][j]==0) {
							System.out.println(year);
							return year;
						}
					}
				}
			}
		}
		if (chec==0) {
			System.out.println(0);
			return 100;
		}else {
			return 0;
		}
	}
	private static void checking(int i, int j) {
		// TODO Auto-generated method stub
			visited[i][j]++;
			if(bingsan[i-1][j]!=0) {
				if(visited[i-1][j]!=1) {
					checking(i-1,j);
				}
			}
			if(bingsan[i+1][j]!=0) {
				if(visited[i+1][j]!=1) {
					checking(i+1,j);
				}
			}
			if(bingsan[i][j-1]!=0) {
				if(visited[i][j-1]!=1) {
					checking(i,j-1);
				}
			}
			if(bingsan[i][j+1]!=0) {
				if(visited[i][j+1]!=1) {
					checking(i,j+1);
				}
			}
	}
	private static void resultmelt() {
		// TODO Auto-generated method stub
		for(int i =0; i<n ; i++) {
			for(int j=0; j<m;j++) {
				bingsan[i][j] = bingsan[i][j] - temp[i][j];
				if(bingsan[i][j]<0) {
					bingsan[i][j]=0;
				}
			}
		}
	}
	private static void print() {
		// TODO Auto-generated method stub
		for(int i =0; i<n ; i++) {
			System.out.println();
			for(int j=0; j<m;j++) {
				System.out.print(bingsan[i][j] +" ");
			}
		}
		
	}

}
