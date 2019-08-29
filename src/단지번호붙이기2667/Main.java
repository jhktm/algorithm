package 단지번호붙이기2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static int n;
	static int[][] town;
	static int[][] visited;
	static int townnumber=0,sum=0;
	static int[] townname;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		
		town = new int[n+2][n+2];
		visited = new int[n+2][n+2];
		townname = new int[n*n];
		for(int i =1;i<n+1;i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			//int number = Integer.parseInt(st.nextToken());
			for(int j =1 ; j<n+1 ; j++) {
				town[i][j] =  s.charAt(j-1)-'0';
			}
		}
		
		for(int i =1;i<n+1;i++) {
			for(int j =1 ; j<n+1 ; j++) {
				if(visited[i][j]==0 && town[i][j]==1) {
					town(i,j,townnumber);
					townname[townnumber] = sum;
					townnumber++;
					sum =0;
				}else {
					visited[i][j]=1;
				}
				
			}
		}
		
		Arrays.sort(townname);
		
		System.out.println(townnumber);
		for(int i =townnumber; i>0;i--) {
			System.out.println(townname[(n*n)-i]);
		}
		//print();
	}


	private static void town(int i, int j, int townnumber) {
		// TODO Auto-generated method stub
		visited[i][j]=1;
		sum++;
		if(visited[i+1][j]==0 &&town[i+1][j]==1) {
			town(i+1,j,townnumber);
		}
		if(visited[i-1][j]==0 &&town[i-1][j]==1) {
			town(i-1,j,townnumber);
		}
		if(visited[i][j+1]==0 &&town[i][j+1]==1) {
			town(i,j+1,townnumber);
		}
		if(visited[i][j-1]==0 &&town[i][j-1]==1) {
			town(i,j-1,townnumber);
		}
		
	}

//	private static void print() {
//		// TODO Auto-generated method stub
//		for(int i =0;i<n+2;i++) {
//			System.out.println();
//			for(int j =0 ; j<n+2 ; j++) {
//				System.out.print(town[i][j]+" ");
//			}
//				
//		}
//	}

}
