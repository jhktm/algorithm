package ������317142;

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
//			System.out.println("���̷��� ��ġ" + x +" "+ y);
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
         
        // r ==0 �̶� ���� ���� ���Ҹ� �� �̾Ҵٴ� ��.
        if(r == 0){
        	clearvirus();
        	realq.addAll(q);
        	for(int i =0; i<M ; i++) {
        		//System.out.println(i +"��°");
        		while(!realq.isEmpty()) {
        			Fileddata temp =realq.poll();
        			if(combArr[i]==temp.no) {
        				tempq.offer(new Fileddata(temp.x,temp.y,0));
        				virus[temp.x][temp.y] = 2;
        				//System.out.println("combArr["+i+"]" +combArr[i]+"���̷��� ��ġ" + temp.x +" "+ temp.y);
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
        //������ �� �˻��� ���..1���� ���� ���¿��� ������ ����� ������ return ���� ����
        }else if(target == n){ 
            return;
         
        }else{
            combArr[index] = target;
            // (i) �̴� ��� 
            // �����ϱ�, r-1
            // �̾����� ���� index + 1 ����� ��
            doCombination(combArr, n, r-1, index+1, target+1, arr);
            
            //(ii) �� �̴°��
            // �Ȼ����ϱ� �״�� r
            // �Ȼ̾�����, index�� �״��!
            // index�� �״���ϸ�, ���� ��� ���� 1�� ������ comArr�� �־�� ���� ��Ϳ� �ٽ� �����ļ� �ᱹ 1������ ���� �ʰ� �ȴ�.
            doCombination(combArr, n, r, index, target+1, arr); 
        }
        
    }
	private static void spreed() {
		// TODO Auto-generated method stub
		//Ư�� ���̷����� �ߵ� ��Ŵ
		//���̷����� ��Ʈ�� 1. ��� ���̷����� ���� 2. Ư�� ���̷����� ����
		while(!tempq.isEmpty()) {
			int x = tempq.peek().x;
			int y = tempq.peek().y;
			int s = tempq.peek().time;

			//System.out.println("���̷��� ��ġ" + x +" "+ y);
			tempq.poll();
			if(visited[x][y]==0) {
				visited[x][y]=1;
				spreedfirst(x,y,s);
			}
			
		}
		//print();
		boolean r = checkallvirus(); // ��� �ʵ尡 ���̷��� ���� �ƴ��� Ȯ��
				//System.out.println("���簪  :" + min);
		if(r) {
			//System.out.println("���簪  :" + min);
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
