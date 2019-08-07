package 삼성연구소14507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;;

public class Main {
	
	
	static int[][] map ; 
	static int[][] vfiled ; 
	static int[][] field ; 
	static int n ; 
	static int m ; 
	static int block = 0;
	static int max = 0;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		field = new int[n+2][m+2];
		
		for(int i = 0 ; i < n+2 ; i++) {
			field[i][0] = 1;
			field[i][m+1] = 1;
		}
		for(int j = 0 ; j < m+2 ; j++) {
			field[0][j] = 1;
			field[n+1][j] = 1;
		}
		
		for(int i = 1 ; i < n+1 ; i++) {
			s = bf.readLine();
			st = new StringTokenizer(s);
			for(int j =1 ; j <m+1 ; j ++) {
				field[i][j] = Integer.parseInt(st.nextToken());			
			}
		}
		
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j =1 ; j <m+1 ; j ++) {	
				//map = field.clone();
				map = copy(field);
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block++;
					secondwall(i,j);
					block--;
					map[i][j] = 0;
				}
				 // 첫번째 벽 세우기
			}
		}
		
		//print();
		System.out.println(max);
		
	}
	private static void secondwall(int x , int y) {
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j =1 ; j <m+1 ; j ++) {	
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block++;
					thirdwall(i,j);
					block--;
					map[i][j] = 0;
				}
				 // 첫번째 벽 세우기
			}
		}
	}
	private static void thirdwall(int x , int y) {
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j =1 ; j <m+1 ; j ++) {	
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block++;
					building(i,j);
					block--;
					map[i][j] = 0;
				}
				 // 첫번째 벽 세우기
			}
		}
	}

	private static void building(int x , int y) {
			
			vfiled = copy(map);
			for(int i = 1 ; i < n+1 ; i++) { // 퍼트리기
				for(int j =1 ; j <m+1 ; j ++) {
					if(vfiled[i][j] == 2) {
						Virus(i,j);
					}
				}
			}
			for(int i = 1 ; i < n+1 ; i++) { //청정구역 찾기
				for(int j =1 ; j <m+1 ; j ++) {
					if(vfiled[i][j] == 0) {
						sum++;
					}
				}
			}
			if(sum>max) {
				max = sum;
			}
			sum = 0;
			
		}

	private static void Virus(int i, int j) {
		// TODO Auto-generated method stub
		vfiled[i][j] = 2;
		if(vfiled[i][j+1]==0) { //오른쪽
			Virus(i,j+1);
		}
		if(vfiled[i][j-1]==0) { // 왼쪽
			Virus(i,j-1);
		}
		if(vfiled[i+1][j]==0) { // 위
			Virus(i+1,j);
		}
		if(vfiled[i-1][j]==0) { //아래
			Virus(i-1,j);
		}
	}
	public static int[][] copy(int[][] input) {
	      int[][] target = new int[input.length][];
	      for (int i=0; i <input.length; i++) {
	        target[i] = Arrays.copyOf(input[i], input[i].length);
	      }
	      return target;
	}
	

}
