package 역사1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//플로이드 와샤
public class Main {

	static int n,k,event;
	static int[][] history;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		history = new int[n+1][n+1];

		for(int i=0;i<k;i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			history[a][b]=-1;
			history[b][a]=1;
		}
		
		 for (int a = 1; a <= n; a++) {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                    if(history[i][a] == 0 || history[i][a] != history[a][j])
	                        continue;
	                    history[i][j] = history[i][a];
	                }
	            }
	        }
		
		
		s = br.readLine();
		st = new StringTokenizer(s);
		event = Integer.parseInt(st.nextToken());//알고싶은 갯수
		
		for(int i=0;i<event;i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(history[a][b]);
			
			
		}
	}
}
