class Solution2 {
	int ma=0, na=0; // �̰� ���߿� �����
	int[][] pictureaa = new int[ma][na];
    public int[] solution(int m, int n, int[][] picture) {
    	ma = m; na = n; pictureaa = picture; // �ϴ� ���� ���� �� �ϱ�
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        long[][] array = new long[m][n]; // �ϴ� �迭 ���� �ٿ��ֱ⸦ �ؾ���
        long color = 0; // �׳� ������ ���ϻ�
        int count=0;
        for (int a=0; a<m; a++) {
        	for (int b=0; b<n; b++) {
        		array[a][b] = picture[a][b];
        		if (array[a][b]>color) color=array[a][b];
        		if (array[a][b]!=0) count++;
        	}
        }
        System.out.println(color+"{}{}"+count);
        // 1 ���� Ž���ϱ�
        this.printarr();
        while(count>0) { // ������ ���ڰ� ���� ����������
        	
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(long color, int r, int c ) { // ã������ �ߴ� ����, ���� ��ġ
    	// �ϳ��� �Ʒ�
    	// �ϳ��� ������
    	// ù��° ��ġ�� ã�������� Ž���ϱ�

    }
    
    public void printarr() { // ��� ����Ʈ �ϳĿ� ���� �ٸ� �� ��
    	for (int a=0; a<na; a++) {
    		for (int b=0; b<ma;b++) {
    			System.out.print(pictureaa[b][a]+" ");
    		}
    		System.out.println();
    	}
    }
}
public class īī��������_�÷����� {

	public static void main(String[] args) {
		// �ѹ� �غ���
		Solution2 s = new Solution2();
		s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		//s.solution(3, 3, new int[][] {{0,1,0}, {1,1,0},{0,0,0}}); // [1,3]
	}

}
