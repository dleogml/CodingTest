package programmers.level2;

// 멀쩡한 사각형
// 가로의 길이 W, 세로의 길이 H인 직사각형이 있고
// 이를 대각선 꼭지점에서 꼭지점으로 대각선으로 선을 그었을 때
// 선에 닿지 않은 사각형의 갯수를 구해라
// 직사각형은 1x1 사각형으로 이루어져 있다.
// 대각선에 닿은 직사각형을 계산하다보면 패턴이 있다
// (w/최대공약수 + h/최대공약수 -1) * 최대공약수 를 계산하면 대각선에 닿은 사각형의 갯수다
// 이를 깔끔하게 정리하면 w + h - 최대공약수이므로
// 전체사각형수(w * h) - (w + h - 최대공약수)를 계산하면 구할 수 있다
public class Quadrangle {
    class Solution {
        public long solution(int w, int h) {
            long answer = 1;
            // int의 범위를 넘어갈 수 있으므로 리턴할 값에는 long으로 변환하여 계산
            long W = w;
            long H = h;

            answer = (W * H) - (W + H - gcd(w,h));

            return answer;
        }
        // 최대 공약수를 구하는 메소드
        // BigInteger라는 클래스를 활용하는 방법도 있다(내부에 gcd 함수가 있음)
        public long gcd(long w, long h) {
            if(h == 0) {
                return w;
            }
            else {
                return gcd(h, w%h);
            }
        }
    }
}
