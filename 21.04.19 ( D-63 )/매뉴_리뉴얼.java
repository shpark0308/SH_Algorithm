import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;import java.util.List;
import java.util.Set;

class Solution {
	Set set = new HashSet<ArrayList<String>>();
	ArrayList<String> rep = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
    	/* ���� order �迭�� ���� ������ ã�� */
    	int[] em = new int[orders.length];

    	this.permutation(orders, 2, em , 0, new ArrayList<String>());
    	ArrayList<ArrayList<String>> setarr = new ArrayList<>(set);
    	System.out.println(setarr);
    	for (int i=0; i<1;i++) { // Set �� �ߺ��Ȱ��� �ִ��� �̾Ƴ��� �۾��� �ϱ�
    		 String s1 = setarr.get(i).get(0); String s2 = setarr.get(i).get(1);
    		 String max1, max2; // �� ���̰� ������� ����� ��
    		 if (s1.length() > s2.length()) {/* ���� �� ���� */max1 = s1; max2 = s2;}
    		 else { max1 = s2; max2 = s1;}
    		 System.out.println("{{"+max1+"}}"+" {{"+max2+"}}"); // �ϴ� CDE �� AC ���ϱ�
    		 for (int b=0; (b<course.length)&&(max2.length()>=course[b]);b++) { // max1�� max2�� ��
    			 System.out.println(b+"||||||||"+course.length+"||||||||"+max2+"||||||"+max2.length()+"||||||"+course[b]);
    			 System.out.println("�� ��� ���°ɱ�");
    		 }
    		 
    	}
        String[] answer = {};
        return answer;
    }
    public void permutation(String[] orders, int k, int[] em, int depth , ArrayList<String> arr ) { // em : visited �ΰ�
    	if (depth == k) {
    		/* ���⿡ �� �� */ // ���ÿ� ArrayList<> �� �߰��ϴ� �������� �ѹ� �غ���
    		ArrayList<String> ar = new ArrayList<>();
    		ar.addAll(arr);
    		Collections.sort(ar);
    		set.add(ar);
    		return;
    	}
    	for (int i=depth; i<orders.length;i++) {
    		if (em[i]==0) { // �湮�� ���� �ʾҴٸ�
    			em[i]=1; arr.add(orders[i]);
    			this.permutation(orders, k, em, depth+1,arr);
    			em[i]=0; arr.remove(arr.size()-1); // �迭 ���� ���� // �ѹ� ���������� ��������
    		}
    	}
    }
}
public class �Ŵ�_������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
		//s.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5});
		//s.solution(new String[] {"XYZ", "XWY", "WXA"},new int[] {2,3,4});
		
		
		

	}

}
