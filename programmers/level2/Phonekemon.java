package programmers.level2;

import java.util.HashSet;

// 폰켓몬
// N마리의 폰켓몬 중에서 N/2마리를 가져갈 수 있고 숫자는 종류를 의미한다
// 최대한 다양한 종류를 뽑는 경우를 찾아서 그 종류의 수를 리턴
// HashSet은 중복을 제거하기 때문에 HashSet의 길이가 종류의 갯수이다
// 최대갯수와 종류의 갯수중 작은 값이 답이 되기 때문에 Math.min으로 구해주면 된다
public class Phonekemon {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int i=0; i<nums.length; i++) {
                hs.add(nums[i]);
            }
            answer = Math.min(hs.size(), nums.length/2);

            return answer;
        }
    }
}
