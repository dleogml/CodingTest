package programmers.level1;

// 최대공약수와 최소공배수
// 두 수의 최대공약수와 최소공배수를 구해서 배열로 리턴
// 문제의 핵심은 유클리드 호제법을 코드로 구현하는 것이다
// 유클리드 호제법은 두수가 주어졌을때 큰수를 작은수로 나눈 나머지를 구해
// 큰수와 작은수의 최대공약수와 작은수와 나머지의 최대공약수가 같다라는 것
// 최소공배수
public class GreatestLeast {
    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            int temp = 1;
            int m2 = m;
            int n2 = n;

            while(temp != 0) {
                temp = m%n;
                m = n;
                n = temp;
            }
            answer[0] = m;
            answer[1] = m2*n2/answer[0];

            return answer;
        }
    }
    // 다른 사람의 최대공약수 구하는 알고리즘
    // 유클리드 호제법인점은 똑같지만 while이 아니라 재귀함수로 구현
    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}

