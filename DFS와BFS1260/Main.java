package DFS와BFS1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n,m,x,y,start;
	static ArrayList<ArrayList<Integer>> arraylist; //인접리스트
	static boolean visited[];
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		
		arraylist = new ArrayList<>(); // 인접리스트 초기화
		visited = new boolean[n+1];
		
		for(int i =0 ; i < n+1 ; i++) {
			arraylist.add(new ArrayList());
		}
		
		for(int i = 0 ; i < m ; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			arraylist.get(x).add(y);
			arraylist.get(y).add(x);
		}
		for(int i = 0 ; i<n+1 ; i++) {
			Collections.sort(arraylist.get(i));
		}
		
		dfs(start);
		System.out.println();
		visited = new boolean[n+1];
		queue.add(start);
		System.out.print(start+" ");
		bfs(start);
	}
	private static void bfs(int index) {
		// TODO Auto-generated method stub
		if(visited[index]==false) {
			visited[index] = true;
		}
		for(int i : arraylist.get(index)) {
			if(visited[i]==false) {
				queue.add(i);
				visited[i]=true;
				System.out.print(i+" ");
			}
		}
		if(!queue.isEmpty()) {
			bfs(queue.poll());
		}
	
		
	
		
		
	}
	private static void dfs(int index) {
		// TODO Auto-generated method stub
		if(visited[index]==false) {
			visited[index] = true;
			System.out.print(index+ " ");
		}else {
			return;
		}
		
		for(int i : arraylist.get(index)) {
			if(visited[i]!=true) {
				dfs(i);
			}
		}
		
	}
	
}
