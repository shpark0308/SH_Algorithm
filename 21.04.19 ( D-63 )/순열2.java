import java.util.HashSet;

class Solution2{
	HashSet<String> set = new HashSet<>();
	public int solution(int[] arr, int k, int[] em, int depth) {  // k : 몇 개를 뽑을 건지 ( 조합 ), em : 배열을 담은 공간,  depth : 현위치
		if (depth == k) {
			this.printArr(em);
			/* em 이 모두 가득 차면 */ // :  set을 reset 해준다 !!
			return set.size();
		}
		for (int i=depth; i<arr.length;i++) {
			if (em[i]==0) { // 아직 방문을 하지 않은 거라면
				em[i]=1;
				this.solution(arr, k, em, depth+1);
				em[i]=0; // 배열을 다시 복원시켜주는 것이 가징 중요함
			}
		}
		return set.size();
		
	}
	public void printArr(int[] ar) { // 이곳에서 배열을 담을 수 있도록 해야함
		String s = "";
		for (int i=0; i<ar.length;i++) {
			if (ar[i]==1) {
				s+=(i+1)+" ";
			}
		}
		set.add(s);
	}
	
}
public class 순열2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		int[] arr1 = {1,2,3,4}; int[] em1 = new int[arr1.length]; // 4개중에서 2개 뽑기
		int[] arr2 = {1,2,3,4,5,6}; int[] em2 = new int[arr2.length]; // 6개 중에서 2개 뽑기
		int[] arr3 = {1,2,3,4,5,6}; int[] em3 = new int[arr3.length];// 6개중에서 3개 뽑기
		//System.out.println(s.solution(arr1, 2,em1, 0)); // set을 reset 해줘야 함
		//System.out.println(s.solution(arr2, 2,em2, 0));
		System.out.println(s.solution(arr3, 3,em3, 0));
	

	}

}
