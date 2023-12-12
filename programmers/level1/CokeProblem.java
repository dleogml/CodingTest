package programmers.level1;

// 콜라 문제
// 빈병을 가지고 비율에 따라 얼마만큼의 새로운 병을 받을 수 있는지 리턴
public class CokeProblem {
    class Solution {
        // a는 새로운 병을 받기위해 줘야하는 병의 갯수
        // b는 받게되는 새로운 병의 수
        // n은 처음 빈병
        public int solution(int a, int b, int n) {
            int answer = 0;
            int remain = n;

            while(remain >= a) {
                int gain = (remain / a) * b;
                System.out.println(gain);
                answer += gain;
                remain = remain - (remain / a) * a + gain;
            }

            return answer;
        }
    }
    // 다른 사람의 풀이
    // 완전히 이해가 되진 않지만 이렇게까지 수학적으로 생각해서 풀어낸게 신기할 따름이다
    class Solution2 {
        public int solution(int a, int b, int n) {
            return (n > b ? n - b : 0) / (a - b) * b;
        }
    }
}
