class Solution2 {
	int ma=0, na=0; // 이거 나중에 지우기
	int[][] pictureaa = new int[ma][na];
    public int[] solution(int m, int n, int[][] picture) {
    	ma = m; na = n; pictureaa = picture; // 일단 복사 전부 다 하기
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        long[][] array = new long[m][n]; // 일단 배열 복사 붙여넣기를 해야함
        long color = 0; // 그냥 임의의 수일뿐
        int count=0;
        for (int a=0; a<m; a++) {
        	for (int b=0; b<n; b++) {
        		array[a][b] = picture[a][b];
        		if (array[a][b]>color) color=array[a][b];
        		if (array[a][b]!=0) count++;
        	}
        }
        System.out.println(color+"{}{}"+count);
        // 1 먼저 탐색하기
        this.printarr();
        while(count>0) { // 아직도 숫자가 남아 있을때까지
        	
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(long color, int r, int c ) { // 찾으려고 했던 색깔, 나의 위치
    	// 하나는 아래
    	// 하나는 오른쪽
    	// 첫번째 위치는 찾을때까지 탐색하기

    }
    
    public void printarr() { // 어떻게 프린트 하냐에 따라 다른 것 뿐
    	for (int a=0; a<na; a++) {
    		for (int b=0; b<ma;b++) {
    			System.out.print(pictureaa[b][a]+" ");
    		}
    		System.out.println();
    	}
    }
}
public class 카카오프렌즈_컬러링북 {

	public static void main(String[] args) {
		// 한번 해보기
		Solution2 s = new Solution2();
		s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		//s.solution(3, 3, new int[][] {{0,1,0}, {1,1,0},{0,0,0}}); // [1,3]
	}

}
