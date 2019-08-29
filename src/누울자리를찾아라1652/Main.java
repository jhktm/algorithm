package 누울자리를찾아라1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,garo=0,sero=0;
	static int[][] bang,garobang,serobang;
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		
		bang = new int[n][n];
		garobang = new int[n][n];
		serobang = new int[n][n];

		for(int i=0;i<n;i++ ) {
			s = br.readLine();
			for(int j=0;j<n;j++) {
				if(s.charAt(j)=='.') {
					bang[i][j] = 0;
				}else {
					bang[i][j] = 1;
				}
			}
		}
		for(int i=0;i<n;i++ ) {
			for(int j=0;j<n;j++) {
				if(bang[i][j]==0) {
					if(garobang[i][j] != 1) {
						garo(i,j);
					}
					if(serobang[i][j] != 1) {
						sero(i,j);
					}
				}
			}
		}
		System.out.print(garo + " ");
		System.out.println(sero);
	}
	private static void sero(int i, int j) {
		// TODO Auto-generated method stub
		if(i+1<n) {
			if(bang[i+1][j] == 0 && serobang[i+1][j] != 1) {
				sero++;
				for(int z = i ; z<n ; z++) {
					if(bang[z][j] != 1) {
						serobang[z][j] = 1;
					}
					else {
						break;
					}
				}
			}
		}
	}
	private static void garo(int i, int j) {
		// TODO Auto-generated method stub
		if(j+1<n) {
			if(bang[i][j+1] == 0 && garobang[i][j+1] != 1) {
				garo++;
				for(int z = j ; z<n ; z++) {
					if(bang[i][z] != 1) {
						garobang[i][z] = 1;
					}
					else {
						break;
					}
				}
				
			}
		}
	}
}
