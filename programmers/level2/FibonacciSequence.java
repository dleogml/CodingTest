package programmers.level2;

// 피보나치 수
// f(n) = f(n-1) + f(n-2) 의 형태의 수열
// n번째 피보나치의 수를 1234567으로 나눈 나머지를 리턴
public class FibonacciSequence {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            if(n == 1 || n == 2) return 1;

            int n1 = 1;
            int n2 = 1;
            int Fibo = 0;

            for(int i=3; i<=n; i++) {
                Fibo = (n1 + n2) % 1234567;
                n1 = n2;
                n2 = Fibo;
            }
            answer = Fibo;

            return answer;
        }
    }

    // 재귀로 푼 피보나치 수
    // 재귀로 풀면 간단하지만 불필요한 연산이 많아져 시간초과가 난다
    class Solution2 {
        public int solution(int n) {
            int answer = 0;

            int ans = Fibonacci(n);
            if(ans > 1234567) {
                ans = ans - 1234567;
            }
            answer = ans % 1234567;

            return answer;
        }

        public int Fibonacci(int n) {
            if(n == 0) {
                return 0;
            }
            if(n == 1) {
                return 1;
            }

            return Fibonacci(n-1) + Fibonacci(n-2);

        }
    }
}
