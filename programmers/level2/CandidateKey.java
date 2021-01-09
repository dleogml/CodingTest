package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 후보키
/* 후보키의 정의
관계 데이터베이스에서 릴레이션(Relation)의 튜플(Tuple)을 유일하게 식별할 수 있는
속성(Attribute) 또는 속성의 집합 중, 다음 두 성질을 만족하는 것을 후보 키(Candidate Key)라고 한다.
유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
                    즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
*/
// 후보키의 개수를 구해서 리턴
public class CandidateKey {
    // DFS를 사용한 풀이
    class Solution {
        ArrayList<HashSet<Integer>> candidateKey;
        String Table[][];
        int length;
        int answer;
        public int solution(String[][] relation) {
            answer = 0;
            candidateKey = new ArrayList<HashSet<Integer>>();
            Table = relation;
            length = relation[0].length;
            for(int i = 1; i <= length; i++) {
                makeSet(-1, i, 0, new HashSet<Integer>());
            }

            return answer;
        }
        // 후보키가 될 수 있는 조합을 구한다
        public void makeSet(int index, int target, int count, HashSet<Integer> set) {

            if(count == target) {
                if(!isUnique(set)) {
                    return;
                }
                for(HashSet<Integer> key: candidateKey) {
                    if(set.containsAll(key)) {
                        return;
                    }
                }
                candidateKey.add(set);
                answer++;
                return;
            }

            for(int i = index + 1; i < length; i++) {
                HashSet<Integer> newSet = new HashSet<Integer>(set);
                newSet.add(i);
                makeSet(i, target, count + 1, newSet);
            }

        }
        // 유일성 검사
        public boolean isUnique(HashSet<Integer> set) {

            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < Table.length; i++) {
                String temp = "";
                for(int index: set) {
                    temp+= Table[i][index];
                }
                if(!list.contains(temp)) {
                    list.add(temp);
                }else {
                    return false;
                }
            }
            return true;
        }
    }
    // 다른 사람의 풀이
    // bit mask를 이용한 풀이
    class Solution2 {
        private boolean possi(List<Integer> list, int now){
            for(int i = 0; i < list.size(); i++){
                if ( (list.get(i) & now) == list.get(i)) return false;
            }
            return true;
        }
        public int solution(String[][] relation) {
            int n = relation.length;        // 가로
            int m = relation[0].length;     // 세로

            List<Integer> list = new ArrayList<Integer>();

            for(int i = 1; i < (1<<m); i++){
                Set<String> s = new HashSet<String>();
                for(int j = 0; j < n; j++){
                    String now = "";
                    for(int k = 0; k < m; k++){
                        if( (i & (1<<k)) > 0 ){
                            // System.out.print((i & (i<<k)) + " ");
                            now += relation[j][k];
                            // System.out.println(relation[j][k]);
                        }
                    }
                    s.add(now);
                }
                if(s.size() == n && possi(list, i) ){
                    list.add(i);
                }
            }
            return list.size();
        }
    }
}
