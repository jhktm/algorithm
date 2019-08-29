package 텀프로젝트9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int T,n,sum = 0,count = 0;
	static ArrayList<ArrayList<Integer>> arraylist;
	static int[] visitnumber;
	static boolean visited[],gotTeam[],alone[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		T = Integer.parseInt(st.nextToken()); // 갯수
		
		
		for(int i = 0 ; i <T ; i++) { // 갯수만큼 반복
			s = br.readLine();
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken()); // 학생 수
			
			
			s = br.readLine();
			st = new StringTokenizer(s);
			
			arraylist = new ArrayList<>();
			for(int j=0 ; j<n+1 ; j++) {
				arraylist.add(new ArrayList());
			}
			
			visited = new boolean[n+1];
			gotTeam = new boolean[n+1];
			visitnumber=new int[n];
			for(int j = 1 ; j<n+1 ; j++) {
				arraylist.get(j).add(Integer.parseInt(st.nextToken()));				
			}
			for(int j = 1 ; j<n+1 ; j++) {
				if(gotTeam[j] == true) {
					
				}else {
					getonestudent(j);
					count=0;
				}
			}
			print();
		}
	}
	
	private static void getonestudent(int i) {
		// TODO Auto-generated method stub
		if(visited[i] == true) {
			boolean status = false;
			for(int s =0 ; s<count ; s++) {
				if(visitnumber[s] == i) {
					status = true;
				}
				gotTeam[visitnumber[s]] = status;
			}
		}else {
			visited[i] = true;
			visitnumber[count]=i;
			count++;
			for(int z : arraylist.get(i)) {
				if(gotTeam[z]==true) {
					gotTeam[i] = false;
				}else {
					getonestudent(z);	
				}
			}
		}
	}
	
	
	
	
	private static void print() {
		// TODO Auto-generated method stub
		for(int j = 1 ; j<n+1 ; j++) {
			if(gotTeam[j]==false) {
				sum++;
			}
		}
		System.out.println(sum);
		sum=0;
	}

}
