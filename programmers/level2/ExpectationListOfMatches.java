package programmers.level2;

// 예상 대진표
// 토너먼트 대진표가 있고 총 참가자수는 N명이다
// 1 2  3 4 .. N-1 N 이런식으로 붙게 되고 이기고 올라온 N/2명은 새로운 번호를 부여받는다
// 12에서 이긴사람은 1번 34에서 이긴사람은 2번 이런식으로 새로운 번호를 부여받는다
// 처음 라운드 번호가 A인 참가자와 B인 참가자가 있을 때 둘이 몇번째 라운드에서 만나는 지 리턴
// 단, A와 B는 서로 만날 때 까지 무조건 이긴다
public class ExpectationListOfMatches {
    class Solution {
        public int solution(int n, int a, int b) {
            int answer = 0;

            // 숫자가 짝수라면 2로 나눠주고 홀수라면 나눠준다음 1을 더해서
            // 같아질때까지 루프를 돌린다
            while(a != b) {
                a = a%2 == 0 ? (a = a/2) : (a = (a/2) + 1);
                b = b%2 == 0 ? (b = b/2) : (b = (b/2) + 1);
                answer++;
            }

            return answer;
        }
    }
}
