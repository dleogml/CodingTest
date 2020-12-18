package programmers.level2;

import java.util.Stack;

// 다음 큰 숫자
// n은 자연수이고 다음 큰 숫자는 세가지 조건을 만족하는 숫자이다
// 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
// 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
// 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
// ex 78(1001110)

// Integer.toBinaryString(n) => n을 이진수로 바꿔줌
// Integer.bitCount(n) => n을 이진수로 바꾼 후 1의 개수를 리턴
public class NextBigNumber {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int count = Integer.bitCount(n);
            int next = n+1;
            while(count != Integer.bitCount(next)) {
                next++;
            }
            answer = next;

            return answer;
        }
    }

    // 나의 풀이
    // 정확성은 다 맞았지만 효율성에선 전부 실패
    class Solution2 {
        public int solution(int n) {
            int answer = 0;
            int next = n+1;
            while(binary(n) != binary(next)) {
                next++;
            }
            answer = next;

            return answer;
        }
        public int binary(int n) {
            int cnt = 0;
            Stack<Integer> stack = new Stack<>();
            while(n > 1) {
                stack.push(n % 2);
                n /= 2;
            }
            stack.push(n);

            while(!stack.empty()) {
                if(stack.peek() == 1) {
                    cnt++;
                }
                stack.pop();
            }

            return cnt;
        }
    }
}
