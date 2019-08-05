package 프린터큐1966;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		
		for(int i = 0 ; i<x ; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			Queue<Integer> imp = new LinkedList<Integer>();//우선순위로 넣기
			Queue<Integer> num = new LinkedList<Integer>();//알고싶은 순서
			int[] pre = new int[n];
			for(int j =0 ; j<n ; j++) {		
				int important = scanner.nextInt(); // 중요도 뽑기
				imp.add(important);
				num.add(j);
				pre[j]=important;
			}
			
			
			Arrays.sort(pre);
			int p = 0;
			int y = pre.length;
			
			
			while(!imp.isEmpty()){
				int first = imp.poll();
				int second = num.poll();
				if(pre[y-1]==first) {
					p++;
					y--;
					if(second == m) {
						System.out.println(p);
						break;
					}
				}else {
					imp.add(first);
					num.add(second);
				}
			}
		}
	}
}
