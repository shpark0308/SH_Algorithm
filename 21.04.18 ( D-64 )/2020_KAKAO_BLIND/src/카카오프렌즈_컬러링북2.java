import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int[][] picarr;
	// �����¿�
	int[] ypointer = {1,-1, 0, 0};
	int[] xpointer = {0, 0,-1, 1};
	// Ŭ���� ����
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
        // �ϴ� �迭 ������� �ϱ�
        for (int a = 0; a<m; a++) {
        	for (int b=0; b<n; b++) {
        		picarr[a][b] = picture[a][b];
        	}
        }
        // �������� ���鼭 Ž��
        for (int c=0; c<n; c++) {
        	for (int d=0; d<m; d++) {
        		// ���⼭���� ���������� �ۼ��ϱ�
        		if (picarr[d][c]>0) { // �� ���鼭 �ִ� �ֵ���� ���� ã�� ����
        			numberOfArea++;
        			int colorcount = this.bfs(d,c, 0, picarr[d][c]);
        			if (colorcount>maxSizeOfOneArea) {
        				maxSizeOfOneArea = colorcount;
        			}
        			
        		}
        	}
        }
        System.out.println("���� ������ {}{}"+numberOfArea+"{}{}"+maxSizeOfOneArea);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int x, int y, int size, int color) { // ������ ������ ���ֱ�
    	/* ���Ṯ �ۼ����ֱ� */
    	
    	// ���⼭���ʹ� ����� �ۼ����ֱ�
    	// BFS�� QUEUE�� �ۼ��ϱ�
    	Queue<Point> queue = new LinkedList<>();
    	queue.add(new Point(x,y));
    	System.out.println("�� �����ִµ� : "+x+"||"+y+"||"+size+"||"+color);
    	while(!queue.isEmpty()) {
    		Point point = queue.poll();
    		// �����¿쿡 ���� for ���� ������� �Ѵ�
    		
    		// 1. ������ �Ͱ� ������( ���� bfs ���� �� ���� �ʿ� ���� queue�� ������ �� ) 2. Ȯ�����ִ� �ڵ尡 �ʿ�
    		// ���� Ȯ���ϴ� �۾� ���� -> for ���� �����ִ� ��
    		if ((point.x>=0 && point.x < picarr.length)&&(point.y>=0&&point.y <picarr[0].length)) { // �ű⿡ �ش��ϴ� ������ ���
    			System.out.println("����� ���ӱ� �Ѱǰ���?????");
    			if (picarr[point.x][point.y]==color) {
    				picarr[point.x][point.y]=0;
        			size++;
        			this.printArr();
        			for (int i=0; i<4; i++) { // for �� ������
        				queue.add(new Point(point.x+xpointer[i], point.y+ypointer[i])); // �����¿�
        			}
    			}
    			
    		}
    	}
    	System.out.println("���� : "+color+" ���� : "+size);
    	return size;
    }
    
    public void printArr() { // ��� ����Ʈ �ϳĿ� ���� �ٸ� �� ��
    	for (int a=0; a<picarr[0].length; a++) {
    		for (int b=0; b<picarr.length;b++) {
    			System.out.print(picarr[b][a]+" ");
    		}
    		System.out.println();
    	}
    }
}
public class īī��������_�÷�����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		//s.solution(3, 3, new int[][] {{0,1,0}, {1,1,0},{0,0,0}}); // [1,3]

	}

}
