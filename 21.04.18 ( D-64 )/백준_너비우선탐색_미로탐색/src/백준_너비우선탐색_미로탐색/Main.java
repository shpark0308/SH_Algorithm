package 백준_너비우선탐색_미로탐색;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int m, n; // 전부 static을 써주는것이 관례이다.
	static int[][] road;
	/* 상하좌우 */
	static int[] move_Y = {1,-1,0,0};
	static int[] move_X = {0,0,1,-1};
	
	public static void solution(int[][] road) {
		// 먼저 탐색부터 하기
		for (int a=0; a<m; a++) {
			for (int b=0; b<n; b++) {
				if (road[a][b]!=0) {
					System.out.println("이건 이거야"+bfs(0,a,b));
				}
			}
		}
	}
	
	public static int bfs(int length, int x, int y ) { // 사이즈 길이 , 현 위치
		/* 각기 다른 Integer 큐로 하기 */
		Queue<Integer> queue_X = new LinkedList<>();
		Queue<Integer> queue_Y = new LinkedList<>();
		Queue<Integer> queue_Num = new LinkedList<>();
		int px, py, num;
		int shortlen = 100001;
		queue_X.add(x); queue_Y.add(y); queue_Num.add(length);
		while(!queue_X.isEmpty()&&!queue_Y.isEmpty()) {
			px = queue_X.poll().intValue(); // intValue(); 
			py = queue_Y.poll().intValue();
			num = queue_Num.poll().intValue();
			// 확인 하는 검증 단계
			System.out.println("{{"+px+"}}"+" {{"+py+"}}"+num);
			if ((px>=0&&px<road.length)&&(py>=0&&py<road[0].length)&&road[px][py]!=0) {
				road[px][py]=0;
				num++;
				printArr();
				System.out.println("----------------- ===== "+num);
				for (int i=0; i<4; i++) { // 상하좌우로 이동
					queue_X.add(px+move_X[i]);
					queue_Y.add(py+move_Y[i]);
					queue_Num.add(num);  // 자신의 길에서 꺼내온 것으로 해야함
				}
			}
			if ((px==road.length-1)&&(py==road[0].length-1)) {
				System.out.println("여기가 끝인가");
				if (num<shortlen) shortlen = num;
				System.out.println("shortlen이 이거니"+shortlen);
			}
			
		}
		length = shortlen;
		System.out.println("최종적인 답은 이건가?"+length);
		return length;
	}
	private static void printArr() {
		for (int a=0; a<road.length;a++) {
			for (int b=0; b<road[0].length;b++) {
				System.out.print(road[a][b]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		road = new int[m][n];
		// 배열 저장
		for (int a=0; a<m; a++) {
			String s = sc.next();
			for (int b = 0; b<n; b++) {
				road[a][b] = s.charAt(b)-48;
			}
		}
		solution(road); // 이게 문제라는 거네
		System.out.println("");
	}

}
