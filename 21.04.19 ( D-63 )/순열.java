class Solution1{
	/* �׸��� ���߿� {{ ���� }} �ϱ� */
	public void solution(int[] arr, int k) {
		//int[] emm = new int[arr.length]; // ���� �׸�ŭ�� �迭�� �������ֱ�
		int[] emm = {0,0,0,0}; // ���� �׸�ŭ�� �迭�� �������ֱ�
		this.dfs(arr, 2, 0, emm);
	}
	public void dfs(int[] arr, int k, int depth, int[] em) { // int depth : �� ��ġ
		if (depth == k) {
			System.out.println("�� �����־�");
			return; // ���⿡ �׳� return �ϸ� ��
			//this.printArr(em); // �ϴ� �غ���
		}
		for (int a=depth; a<arr.length;a++ ) { // �ϴ� �̷��� �ۼ��ϱ�
			// �ϴ� �̷������� �ۼ��ϱ�
			int[] exa = em.clone();
			/*System.out.println("�䵿�䵿1");
			this.printArr(exa);
			this.dfs(arr, k, depth+1, exa);*/ // -> ���� �Ϳ� ���ؼ��� �ص� ������
			//exa[a]=1;
			if (exa[a]!=1) { // �ٽ� �ݺ����� �ʵ���
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
public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �迭�� �޾Ƶ��̰� �ϱ�
		int[] arr1 = {1,2,3,4}; // ���� 4���߿��� 2�� �����ϴ� ��
		int[] arr2 = {1,2,3,4,5,6}; // ���� 6���߿��� 2�� �����ϴ� ��
		int[] arr3 = {1,2,3,4,5,6}; // 6���߿��� 3�� �����ϴ� ��
		Solution1 s = new Solution1();
		s.solution(arr1, 2);
		//s.solution(arr2, 2);
		//s.solution(arr3, 3);
	}

}
