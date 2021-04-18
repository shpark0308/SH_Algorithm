import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int[][] picarr;
	// 상하좌우
	int[] ypointer = {1,-1, 0, 0};
	int[] xpointer = {0, 0,-1, 1};
	// 클래스 생성
	public class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = -1;
        picarr = new int[m][n];
        // 일단 배열 복사부터 하기
        for (int a = 0; a<m; a++) {
        	for (int b=0; b<n; b++) {
        		picarr[a][b] = picture[a][b];
        	}
        }
        // 이제부터 돌면서 탐색
        for (int c=0; c<n; c++) {
        	for (int d=0; d<m; d++) {
        		// 여기서부터 본격적으로 작성하기
        		if (picarr[d][c]>0) { // 다 돌면서 있는 애들부터 전부 찾는 거지
        			numberOfArea++;
        			int colorcount = this.bfs(d,c, 0, picarr[d][c]);
        			if (colorcount>maxSizeOfOneArea) {
        				maxSizeOfOneArea = colorcount;
        			}
        			
        		}
        	}
        }
        System.out.println("최종 정답은 {}{}"+numberOfArea+"{}{}"+maxSizeOfOneArea);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int x, int y, int size, int color) { // 영역의 갯수를 세주기
    	/* 종결문 작성해주기 */
    	
    	// 여기서부터는 여기다 작성해주기
    	// BFS는 QUEUE로 작성하기
    	Queue<Point> queue = new LinkedList<>();
    	queue.add(new Point(x,y));
    	System.out.println("나 여기있는데 : "+x+"||"+y+"||"+size+"||"+color);
    	while(!queue.isEmpty()) {
    		Point point = queue.poll();
    		// 상하좌우에 대한 for 문을 돌려줘야 한다
    		
    		// 1. 돌리는 것과 별개로( 굳이 bfs 문을 더 돌릴 필요 없이 queue에 담으면 됨 ) 2. 확인해주는 코드가 필요
    		// 먼저 확인하는 작업 이후 -> for 문을 돌려주는 것
    		if ((point.x>=0 && point.x < picarr.length)&&(point.y>=0&&point.y <picarr[0].length)) { // 거기에 해당하는 범위에 들면
    			System.out.println("여기로 들어왓긴 한건가용?????");
    			if (picarr[point.x][point.y]==color) {
    				picarr[point.x][point.y]=0;
        			size++;
        			this.printArr();
        			for (int i=0; i<4; i++) { // for 문 돌리기
        				queue.add(new Point(point.x+xpointer[i], point.y+ypointer[i])); // 상하좌우
        			}
    			}
    			
    		}
    	}
    	System.out.println("색깔 : "+color+" 갯수 : "+size);
    	return size;
    }
    
    public void printArr() { // 어떻게 프린트 하냐에 따라 다른 것 뿐
    	for (int a=0; a<picarr[0].length; a++) {
    		for (int b=0; b<picarr.length;b++) {
    			System.out.print(picarr[b][a]+" ");
    		}
    		System.out.println();
    	}
    }
}
public class 카카오프렌즈_컬러링북2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		//s.solution(3, 3, new int[][] {{0,1,0}, {1,1,0},{0,0,0}}); // [1,3]

	}

}
