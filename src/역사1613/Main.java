package 역사1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//플로이드 와샤
public class Main {

	static int n,k,event;
	static ArrayList<ArrayList<Integer>> arraylistfront,arraylistback;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arraylistfront = new  ArrayList<>();
		for(int i=0;i<n+1;i++) {
			arraylistfront.add(new ArrayList());
		}
		arraylistback = new  ArrayList<>();
		for(int i=0;i<n+1;i++) {
			arraylistback.add(new ArrayList());
		}
		
		for(int i=0;i<k;i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arraylistfront.get(a).add(b);
			arraylistback.get(b).add(a);
		}
		
		s = br.readLine();
		st = new StringTokenizer(s);
		event = Integer.parseInt(st.nextToken());//알고싶은 수
		
		
		for(int i=0;i<event;i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = 0;
			

			result = front(a,b);
			if(result == 1) {
				System.out.println(-1);
			}else {
				result = back(a,b);
				if(result==1) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}
	}

	private static int back(int a, int b) {
		// TODO Auto-generated method stub
		for(int i : arraylistback.get(a)) {
			if(i==b) {
				return 1;
			}else {
				return back(i,b);
				
			}
		}
		return 0;
	}

	private static int front(int a, int b) {
		// TODO Auto-generated method stub
		for(int i:arraylistfront.get(a)) {
			if(i==b) {
				return 1;
			}else {
				return front(i,b);
			}
		}

		return 0;
	}

}
