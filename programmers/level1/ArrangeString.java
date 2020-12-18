package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 문자열 내 마음대로 정렬하기
// 주어진 인덱스의 글자 순서로 단어를 정렬
// 인덱스가 같다면 단어 사전순으로 정렬
public class ArrangeString {
    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};
            ArrayList<String> list = new ArrayList<>();

            // 인덱스 n번째 글자를 문자열앞에다가 붙이고
            // 뒤이어 기존 문자열을 붙여서 새로운 문자열 배열 만듬
            for(int i=0; i<strings.length; i++) {
                list.add(strings[i].charAt(n) + strings[i]);
            }

            // 이 배열을 sort하게 되면 앞에 문자열에 따라 정렬되고
            // 같으면 뒤에 단어에 따라 정렬됨
            Collections.sort(list);

            // 문자열 1부터 즉, 앞에 붙인 것말고 기존단어시작부터 다시 잘라서 넣어줌
            answer = new String[list.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i).substring(1, list.get(i).length());
            }

            return answer;
        }
    }

    // 다른 사람의 풀이
    // Comparable - compareTo() 일반적인 기준 정렬
    // Comparator - compare() 특정한 기준 정렬
    class Solution2 {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    if(s1.charAt(n) > s2.charAt(n)) return 1;
                    else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                    else if(s1.charAt(n) < s2.charAt(n)) return -1;
                    else return 0;
                }
            });
            return strings;
        }
    }
}
