package 나무재테크16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K,tree=0;
	static int[][] feed,filed,wall;
	static ArrayList<ArrayList<Integer>> arrayList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken()); // NxN의 땅의크기
		M = Integer.parseInt(st.nextToken()); // M개의 나무 갯수
		K = Integer.parseInt(st.nextToken()); //년이 지난후

		feed = new int[N+2][N+2];
		filed = new int[N+2][N+2];
		wall = new int[N+2][N+2];
		for(int i = 0 ; i<N+2 ; i++) {
			wall[0][i] = 1;
			wall[N+1][i] = 1;
			wall[i][0] = 1;
			wall[i][N+1] = 1;
		}
		arrayList = new ArrayList<>();
		for(int i = 1 ; i<N+1 ; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for(int j = 1 ; j<N+1 ; j++) {
				feed[i][j] = Integer.parseInt(st.nextToken());
				filed[i][j] =5;
				arrayList.add(new ArrayList());
			}
		}
		arrayList.add(new ArrayList());
		// 겨울에 땅에 줄 양분
		
		// 나무 심어진곳
		for(int i = 0 ; i<M ; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arrayList.get(((x-1)*N)+y).add(z);
		}
		
		
		for(int i = 0; i < K ; i++) {
			
			spring();

			
			fall();
		}
		findTree();
		System.out.println(tree);
	}

	private static void findTree() {
		// TODO Auto-generated method stub
		for(int i = 1 ; i<N+1 ; i++) {
			for(int j = 1 ; j<N+1 ; j++) {
				int temp = ((i-1)*N)+j;
				if(!arrayList.get(temp).isEmpty()){
					for(int t : arrayList.get(temp)) {
						tree++;
					}
					
				}
			}
		}
	}
	private static void fall() {
		// TODO Auto-generated method stub
		for(int i = 1 ; i<N+1 ; i++) {
			for(int j = 1 ; j<N+1 ; j++) {
				int temp = ((i-1)*N)+j;
				filed[i][j] = filed[i][j]+feed[i][j];
				if(!arrayList.get(temp).isEmpty()){
					for(int t : arrayList.get(temp)) {
						if(t>4 && t%5==0) {
							speed(i,j);
						}
					}
				}
			}
		}
	}

	private static void speed(int i, int j) {
		// TODO Auto-generated method stub
		int temp=0;
		if(wall[i+1][j] != 1) {
			temp = (i)*N+j;
			arrayList.get(temp).add(1);
		}
		if(wall[i+1][j+1] != 1) {
			temp = (i)*N+j+1;
			arrayList.get(temp).add(1);
		}
		if(wall[i+1][j-1] != 1) {
			temp = (i)*N+j-1;
			arrayList.get(temp).add(1);
		}
		if(wall[i][j+1] != 1) {
			temp = (i-1)*N+j+1;
			arrayList.get(temp).add(1);
		}
		if(wall[i][j-1] != 1) {
			temp = (i-1)*N+j-1;
			arrayList.get(temp).add(1);
		}
		if(wall[i-1][j] != 1) {
			temp = (i-2)*N+j;
			arrayList.get(temp).add(1);
		}
		if(wall[i-1][j+1] != 1) {
			temp = (i-2)*N+j+1;
			arrayList.get(temp).add(1);
		}
		if(wall[i-1][j-1] != 1) {
			temp = (i-2)*N+j-1;
			arrayList.get(temp).add(1);
		}
	}

	private static void spring() {
		// TODO Auto-generated method stub
		for(int i = 1 ; i<N+1 ; i++) {
			//System.out.println();
			for(int j = 1 ; j<N+1 ; j++) {
				int temp = ((i-1)*N)+j;
				if(!arrayList.get(temp).isEmpty()){
					Collections.sort(arrayList.get(temp));
					int tempfeed = 0;
					int index =0;
					for(int t : arrayList.get(temp)) {
						tempfeed = tempfeed+(t/2);
						if(filed[i][j] >= t) {
							index++;
							filed[i][j] = filed[i][j]-t;
							tempfeed = tempfeed -(t/2);
							int tempindex = arrayList.get(temp).indexOf(t);
							arrayList.get(temp).set(tempindex,t+1);
						}else {
							
						}
					}
					int max = arrayList.get(temp).size();
					for(int t = index ; t<max; t++) {
						arrayList.get(temp).remove(index);
					}
					filed[i][j] = filed[i][j]+tempfeed;
				}
				
			}
		}
	}
}
