class Solution1{
	/* 그리고 나중에 {{ 수정 }} 하기 */
	public void solution(int[] arr, int k) {
		//int[] emm = new int[arr.length]; // 먼저 그만큼의 배열을 생성해주기
		int[] emm = {0,0,0,0}; // 먼저 그만큼의 배열을 생성해주기
		this.dfs(arr, 2, 0, emm);
	}
	public void dfs(int[] arr, int k, int depth, int[] em) { // int depth : 현 위치
		if (depth == k) {
			System.out.println("나 여기있어");
			return; // 여기에 그냥 return 하면 됨
			//this.printArr(em); // 일단 해보기
		}
		for (int a=depth; a<arr.length;a++ ) { // 일단 이렇게 작성하기
			// 일단 이런식으로 작성하기
			int[] exa = em.clone();
			/*System.out.println("토동토동1");
			this.printArr(exa);
			this.dfs(arr, k, depth+1, exa);*/ // -> 갔던 것에 대해서만 해도 괜찮음
			//exa[a]=1;
			if (exa[a]!=1) { // 다시 반복되지 않도록
				exa[a]=1;			
				this.printArr(exa);
				this.dfs(arr, k, depth+1, exa);
				exa[a]=0;
			}
			
		}
		
	}
	public void printArr(int[] emmm) {
		for (int i=0; i<emmm.length; i++) {
			System.out.print(emmm[i]+" ");
			/*if (emmm[i]==1) {
				System.out.print(emmm[i]+" ");
				//System.out.println(i);
			}*/
			
		}
		System.out.println();
	}
	
	
}
public class 순열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열로 받아들이게 하기
		int[] arr1 = {1,2,3,4}; // 먼저 4개중에서 2개 선택하는 것
		int[] arr2 = {1,2,3,4,5,6}; // 다음 6개중에서 2개 선택하는 것
		int[] arr3 = {1,2,3,4,5,6}; // 6개중에서 3개 선택하는 것
		Solution1 s = new Solution1();
		s.solution(arr1, 2);
		//s.solution(arr2, 2);
		//s.solution(arr3, 3);
	}

}
