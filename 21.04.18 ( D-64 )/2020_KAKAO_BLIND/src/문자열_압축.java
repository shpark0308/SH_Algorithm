class Solution1 {
    public int solution(String s) {
    	// ���ڿ� �� : �ϴ� �غ���
    	// ���� 3���� �� // �׸��� �տ������� ��
    	int num=1, count=0, smalllen=1001;
    	String returnstr = "";
    	String smallstr = "";
    	for (num=1; num<s.length();num++) {
    		System.out.println(num+"�� Ű��Ű��"+s);
    		returnstr = "";
    		for (int b=0; b<s.length()-num; b+=num) {
        		// b �� �ٲپ� �ָ� ��
        		String str1 = s.substring(b, b+num);
        		String str2 = s.substring(b+num, b+2*num<s.length()?b+2*num:s.length()); // �ٷ� �������� �Ͱ� ��
        		System.out.println(str1+"{}{}"+str2);
        		count=1;
        		if (str1.equals(str2)) {
        			do {
        				b = b+num;
        				count++;
        				if (b+num>=s.length()) break;
        				str2 = s.substring(b+num, b+2*num<s.length()?b+2*num:s.length());
        				System.out.println("�� �����");
        			}while((str1.equals(str2))&&(b<s.length()-num)); // �׷� ���� ���� �� �����ϴ� �ͺ��� �ؾ���
        		}
        		returnstr += count==1?str1:Integer.toString(count)+str1;
        		if (!str1.equals(str2)) {
        			System.out.println("�׷� �������� ���Գ�");
        			if (b+num>=s.length()-num) {
        				returnstr+=str2;
        			}
        		}
        		//returnstr += count==1?str1:Integer.toString(count)+str1;
        		//System.out.println(str1+"//"+str2);
        	}
    		if (returnstr.length()<smalllen) {
    			smalllen = returnstr.length();
    			smallstr = returnstr;
    		}
        	System.out.println("{{smalllen}} : "+smalllen+" {{smallstr}} : "+smallstr);
    	}
    	
    	
    	// ���� 5�� ��
    	
        int answer = (smalllen!=1001)?smalllen:1;
        System.out.println("{{smalllen}} : "+answer+" {{smallstr}} : "+smallstr);
        return answer;
    }
}

public class ���ڿ�_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		//s.solution("aabbaccc");
		//s.solution("ababcdcdababcdcd");
		//s.solution("abcabcdede");
		//s.solution("abcabcabcabcdededededede");
		//s.solution("xababcdcdababcdcd"); // �� �������͸� ���������� Ȯ���ϱ�
		s.solution("xxxxxxxxxxyyy");

	}

}
