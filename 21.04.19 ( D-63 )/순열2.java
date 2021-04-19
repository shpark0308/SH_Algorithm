import java.util.HashSet;

class Solution2{
	HashSet<String> set = new HashSet<>();
	public int solution(int[] arr, int k, int[] em, int depth) {  // k : �� ���� ���� ���� ( ���� ), em : �迭�� ���� ����,  depth : ����ġ
		if (depth == k) {
			this.printArr(em);
			/* em �� ��� ���� ���� */ // :  set�� reset ���ش� !!
			return set.size();
		}
		for (int i=depth; i<arr.length;i++) {
			if (em[i]==0) { // ���� �湮�� ���� ���� �Ŷ��
				em[i]=1;
				this.solution(arr, k, em, depth+1);
				em[i]=0; // �迭�� �ٽ� ���������ִ� ���� ��¡ �߿���
			}
		}
		return set.size();
		
	}
	public void printArr(int[] ar) { // �̰����� �迭�� ���� �� �ֵ��� �ؾ���
		String s = "";
		for (int i=0; i<ar.length;i++) {
			if (ar[i]==1) {
				s+=(i+1)+" ";
			}
		}
		set.add(s);
	}
	
}
public class ����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		int[] arr1 = {1,2,3,4}; int[] em1 = new int[arr1.length]; // 4���߿��� 2�� �̱�
		int[] arr2 = {1,2,3,4,5,6}; int[] em2 = new int[arr2.length]; // 6�� �߿��� 2�� �̱�
		int[] arr3 = {1,2,3,4,5,6}; int[] em3 = new int[arr3.length];// 6���߿��� 3�� �̱�
		//System.out.println(s.solution(arr1, 2,em1, 0)); // set�� reset ����� ��
		//System.out.println(s.solution(arr2, 2,em2, 0));
		System.out.println(s.solution(arr3, 3,em3, 0));
	

	}

}
