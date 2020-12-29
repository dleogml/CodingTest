package programmers.level2;

import java.util.ArrayList;

// 뉴스 클러스터링
// 어떤 기사를 검색했을 때 이를 묶기 위해 기준을 세웠다. 여기에 자카드 유사도라는걸 사용한다
// 자카드 유사드는 두 집합의 교집합의 크기를 합집합의 크기로 나눈 값이다.
// ex) A={1, 2, 3}, B={2, 3, 4} 일 때
// 교집합={2, 3} 크기2 / 합집합={1, 2, 3, 4} 크기4 이므로 자카드 유사도는 2/4 = 0.5가 된다
// 두집합이 공집합일경우는 유사도는 1로 정의한다.
// 문자열 2개가 주어지면 두글자씩 끊어서 이를 원소로 하는 집합으로 한다
// FRANCE, FRENCH 두개라고 할 때
// {FR, RA, AN, NC, CE} / {FR, RE, EN, NC, CH}
// 교집합={FR, NC} 합집합={FR, RA, AN, NC, CE, RE, EN, CH} 가 되고 유사도는 2/8 = 0.25가 된다
// + 같은 특수문자는 없앤다
// ex) ab+ 이면 ab는 원소가 되지만 b+은 원소가 되지않고 스킵된다
// 두 문자열사이의 유사도를 구한뒤 65536을 곱한 뒤 소수점 아래는 버리고 정수부분만 리턴
public class NewsClustering {
    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            // 영어를 제외한 다른 문자는 0으로 대체
            str1 = str1.replaceAll("[^a-zA-Z]","0").toLowerCase();
            str2 = str2.replaceAll("[^a-zA-Z]","0").toLowerCase();

            ArrayList<String> aList = new ArrayList<>();
            ArrayList<String> bList = new ArrayList<>();

            // 두 글자씩 끊기
            // 0이 두글자 범위내의 0이없다면(특수문자 등) 끊어서 저장
            for(int i=0; i<str1.length()-1; i++) {
                if(!str1.substring(i,i+2).contains("0"))
                    aList.add(str1.substring(i,i+2));
            }
            for(int i=0; i<str2.length()-1; i++) {
                if(!str2.substring(i,i+2).contains("0"))
                    bList.add(str2.substring(i,i+2));
            }

            // 교집합과 합집합의 크기
            double inter = intersection(aList,bList).size();
            double union = aList.size() + bList.size() - inter;

            // 공집합인 경우 1이므로 65536 리턴
            // 아닌 경우 공식에 대입
            if(inter == 0 && union == 0)
                return 65536;
            else
                answer = (int)(inter/union * 65536);

            return answer;
        }
        // 교집합 메소드
        ArrayList<String> intersection(ArrayList<String> A, ArrayList<String> B) {
            A = (ArrayList<String>) A.clone();
            B = (ArrayList<String>) B.clone();
            ArrayList<String> list = new ArrayList<>();
            for(String s : A) {
                if(B.contains(s)) {
                    list.add(s);
                    B.remove(s);
                }
            }
            return list;
        }
    }
}
