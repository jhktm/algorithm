package 연구소317142;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
//bfs
	static class Fileddata{
		int x;
		int y;
		int time;
		int virus;
		int no;
		public Fileddata(int i, int j,int s,int no) {
			// TODO Auto-generated constructor stub
				this.x = i;
				this.y = j;
				this.time = s;
				this.virus = 2;
				this.no = no;
			}
		public Fileddata(int i, int j,int s) {
		// TODO Auto-generated constructor stub
			this.x = i;
			this.y = j;
			this.time = s;
			this.virus = 2;
		}
	}
	static int N,M,min=9999;
	static int[][] filed,virus,visited,time;
	static Queue<Fileddata> q = new LinkedList<Fileddata>();
	static Queue<Fileddata> tempq = new LinkedList<Fileddata>();
	static Queue<Fileddata> realq = new LinkedList<Fileddata>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		filed = new int[N+2][N+2];
		virus = new int[N+2][N+2];
		visited = new int[N+2][N+2];
		time= new int[N+2][N+2];
		for(int i=0 ; i<N+2 ; i++) {
			filed[0][i]=1;
			filed[N+1][i]=1;
			filed[i][0]=1;
			filed[i][N+1]=1;
		}
		
		int no = 0;
		for(int i = 1;i<N+1 ; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for(int j = 1 ; j<N+1 ; j++) {
				filed[i][j] = Integer.parseInt(st.nextToken());
				if(filed[i][j]==2) {
					q.offer(new Fileddata(i,j,0,no));
					no++;
				}
			}
		}
		
		for(int i=0 ; i<N+2 ; i++) {
			virus[i] = filed[i].clone(); 
		}
		
		//print();
//		while(!q.isEmpty()) {
//			int x = q.peek().x;
//			int y = q.peek().y;
//			System.out.println("바이러스 위치" + x +" "+ y);
//			q.poll();
//		}
		
		int[] combArr = new int[M];
		int[] arr = { 0,1,2,3,4,5,6,7,8,9};
		doCombination(combArr, no, M, 0, 0, arr);
		if(min==9999) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		//spreed();
		//print();
	}
	
	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        //System.out.println("=> "+n+" "+r+" "+index+" "+target);
         
        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if(r == 0){
        	clearvirus();
        	realq.addAll(q);
        	for(int i =0; i<M ; i++) {
        		//System.out.println(i +"번째");
        		while(!realq.isEmpty()) {
        			Fileddata temp =realq.poll();
        			if(combArr[i]==temp.no) {
        				tempq.offer(new Fileddata(temp.x,temp.y,0));
        				virus[temp.x][temp.y] = 2;
        				//System.out.println("combArr["+i+"]" +combArr[i]+"바이러스 위치" + temp.x +" "+ temp.y);
        				break;
        			}else {
        				
        			}
        			
        		}
        	}
        	spreed();
        	realq.clear();
        	tempq.clear();
        	visited = new int[N+2][N+2];
        	time = new int[N+2][N+2];
        	for(int i=0 ; i<N+2 ; i++) {
    			virus[i] = filed[i].clone(); 
    		}
        	//print();
            //System.out.println(Arrays.toString(combArr));
            //for(int i=0; i<index; i++)System.out.print(arr[combArr[i]] + " ");
           
           // System.out.println();
        //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        }else if(target == n){ 
            return;
         
        }else{
            combArr[index] = target;
            // (i) 뽑는 경우 
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r-1, index+1, target+1, arr);
            
            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            // index를 그대로하면, 예를 들어 현재 1번 구슬을 comArr에 넣엇어도 다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
            doCombination(combArr, n, r, index, target+1, arr); 
        }
        
    }
	private static void spreed() {
		// TODO Auto-generated method stub
		//특정 바이러스만 발동 시킴
		//바이러스를 퍼트림 1. 모든 바이러스가 퍼짐 2. 특정 바이러스만 터짐
		while(!tempq.isEmpty()) {
			int x = tempq.peek().x;
			int y = tempq.peek().y;
			int s = tempq.peek().time;

			//System.out.println("바이러스 위치" + x +" "+ y);
			tempq.poll();
			if(visited[x][y]==0) {
				visited[x][y]=1;
				spreedfirst(x,y,s);
			}
			
		}
		//print();
		boolean r = checkallvirus(); // 모든 필드가 바이러스 인지 아닌지 확인
				//System.out.println("현재값  :" + min);
		if(r) {
			//System.out.println("현재값  :" + min);
		}
	}
	
	private static void spreedfirst(int i, int j,int s) {
		// TODO Auto-generated method stub
			if(virus[i+1][j]==0){
				virus[i+1][j]=2;
				time[i+1][j]=s+1;
				tempq.offer(new Fileddata(i+1,j,s+1));
			}
			if(virus[i-1][j]==0){
				virus[i-1][j]=2;
				time[i-1][j]=s+1;
				tempq.offer(new Fileddata(i-1,j,s+1));
			}
			if(virus[i][j+1]==0){
				virus[i][j+1]=2;
				time[i][j+1]=s+1;
				tempq.offer(new Fileddata(i,j+1,s+1));
			}
			if(virus[i][j-1]==0){
				virus[i][j-1]=2;
				time[i][j-1]=s+1;
				tempq.offer(new Fileddata(i,j-1,s+1));
			}
		
	}
	private static boolean checkallvirus() {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i = 1;i<N+1 ; i++) {
			for(int j = 1 ; j<N+1 ; j++) {
				if(virus[i][j]==0) {
					return false;
				}else if(virus[i][j]==2){
					if(time[i][j]>max && filed[i][j]!=2) {
						max=time[i][j];
					}
				}
			}
		}
		if(min>max) {
			min = max;
		}
		return true;
	}
	private static void clearvirus() {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i = 1;i<N+1 ; i++) {
			for(int j = 1 ; j<N+1 ; j++) {
				if(virus[i][j]==2) {
					virus[i][j]=0;
				}
			}
		}
	}
	private static void print() {
		// TODO Auto-generated method stub
		for(int i = 0;i<N+2 ; i++) {
			System.out.println();
			for(int j = 0 ; j<N+2 ; j++) {
				System.out.print(time[i][j]+" ");
			}
		}
		
//		for(int i = 0;i<N+2 ; i++) {
//			System.out.println();
//			for(int j = 0 ; j<N+2 ; j++) {
//				System.out.print(time[i][j]+" ");
//				
//			}
//		}
		System.out.println();
	}
}
