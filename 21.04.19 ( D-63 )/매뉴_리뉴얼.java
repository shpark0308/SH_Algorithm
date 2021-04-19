import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;import java.util.List;
import java.util.Set;

class Solution {
	Set set = new HashSet<ArrayList<String>>();
	ArrayList<String> rep = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
    	/* 먼저 order 배열의 순열 조합을 찾기 */
    	int[] em = new int[orders.length];

    	this.permutation(orders, 2, em , 0, new ArrayList<String>());
    	ArrayList<ArrayList<String>> setarr = new ArrayList<>(set);
    	System.out.println(setarr);
    	for (int i=0; i<1;i++) { // Set 에 중복된것을 최대한 뽑아내는 작업을 하기
    		 String s1 = setarr.get(i).get(0); String s2 = setarr.get(i).get(1);
    		 String max1, max2; // 더 길이가 긴것으로 맞춰야 함
    		 if (s1.length() > s2.length()) {/* 이제 비교 들어가기 */max1 = s1; max2 = s2;}
    		 else { max1 = s2; max2 = s1;}
    		 System.out.println("{{"+max1+"}}"+" {{"+max2+"}}"); // 일단 CDE 와 AC 비교하기
    		 for (int b=0; (b<course.length)&&(max2.length()>=course[b]);b++) { // max1과 max2의 비교
    			 System.out.println(b+"||||||||"+course.length+"||||||||"+max2+"||||||"+max2.length()+"||||||"+course[b]);
    			 System.out.println("난 몇번 들어온걸까");
    		 }
    		 
    	}
        String[] answer = {};
        return answer;
    }
    public void permutation(String[] orders, int k, int[] em, int depth , ArrayList<String> arr ) { // em : visited 인것
    	if (depth == k) {
    		/* 여기에 둔 것 */ // 동시에 ArrayList<> 에 추가하는 방향으로 한번 해보기
    		ArrayList<String> ar = new ArrayList<>();
    		ar.addAll(arr);
    		Collections.sort(ar);
    		set.add(ar);
    		return;
    	}
    	for (int i=depth; i<orders.length;i++) {
    		if (em[i]==0) { // 방문을 하지 않았다면
    			em[i]=1; arr.add(orders[i]);
    			this.permutation(orders, k, em, depth+1,arr);
    			em[i]=0; arr.remove(arr.size()-1); // 배열 원상 복귀 // 한번 마지막것을 지워보기
    		}
    	}
    }
}
public class 매뉴_리뉴얼 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
		//s.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5});
		//s.solution(new String[] {"XYZ", "XWY", "WXA"},new int[] {2,3,4});
		
		
		

	}

}
