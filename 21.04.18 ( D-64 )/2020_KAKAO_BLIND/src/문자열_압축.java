class Solution1 {
    public int solution(String s) {
    	// 문자열 비교 : 일단 해보기
    	// 만약 3으로 비교 // 그리고 앞에서부터 비교
    	int num=1, count=0, smalllen=1001;
    	String returnstr = "";
    	String smallstr = "";
    	for (num=1; num<s.length();num++) {
    		System.out.println(num+"은 키득키득"+s);
    		returnstr = "";
    		for (int b=0; b<s.length()-num; b+=num) {
        		// b 만 바꾸어 주면 됨
        		String str1 = s.substring(b, b+num);
        		String str2 = s.substring(b+num, b+2*num<s.length()?b+2*num:s.length()); // 바로 연속적인 것과 비교
        		System.out.println(str1+"{}{}"+str2);
        		count=1;
        		if (str1.equals(str2)) {
        			do {
        				b = b+num;
        				count++;
        				if (b+num>=s.length()) break;
        				str2 = s.substring(b+num, b+2*num<s.length()?b+2*num:s.length());
        				System.out.println("나 여기야");
        			}while((str1.equals(str2))&&(b<s.length()-num)); // 그럼 이제 같을 때 압축하는 것부터 해야함
        		}
        		returnstr += count==1?str1:Integer.toString(count)+str1;
        		if (!str1.equals(str2)) {
        			System.out.println("그럼 이쪽으로 들어왔나");
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
    	
    	
    	// 만약 5로 비교
    	
        int answer = (smalllen!=1001)?smalllen:1;
        System.out.println("{{smalllen}} : "+answer+" {{smallstr}} : "+smallstr);
        return answer;
    }
}

public class 문자열_압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		//s.solution("aabbaccc");
		//s.solution("ababcdcdababcdcd");
		//s.solution("abcabcdede");
		//s.solution("abcabcabcabcdededededede");
		//s.solution("xababcdcdababcdcd"); // 맨 마지막것만 마지막으로 확인하기
		s.solution("xxxxxxxxxxyyy");

	}

}
