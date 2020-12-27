package programmers.level2;

// N개의 최소공배수
// n개의 숫자가 주어졌을 때, 이 숫자들의 최소공배수를 구해서 리턴
// 두수가 a,b라고 했을 때 두수의 최소공배수는 a * b / 최대공약수 이다.
public class NLeastCommonMultiple {
    class Solution {
        public int solution(int[] arr) {
            int answer = 0;
            int start = arr[0];
            // 앞에서부터 두수의 최소공배수를 구하고 그 수를 다음수와 다시 최소공배수를 구함
            for(int i=1; i<arr.length; i++) {
                answer = start * arr[i] / gcd(start, arr[i]);
                start = answer;
            }

            return answer;

        }
        // 최대공약수를 구하는 메소드
        public int gcd(int a, int b) {
            if(a % b == 0) {
                return b;
            }
            return gcd(b, a%b);
        }
    }
}
