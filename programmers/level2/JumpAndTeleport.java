package programmers.level2;

// 점프와 순간이동
// K칸 점프하거나 (현재까지 온거리) x 2의 위치로 순간이동하거나 둘 중 하나를 할 수 있다.
// 순간이동에는 건전지 사용량이 없지만 점프는 점프한 칸수만큼 건전지 사용량이 든다.
// 거리 N이 주어졌을 때 건전지를 가장 적게 사용하는 경우를 계산해서 그 때의 건전지 사용량을 리턴
// 주어진 수를 이진법으로 변환했을 때 1의 갯수는 이동한 칸의수, 0의 갯수는 점프한 수이다
// 점프가 2배씩 늘어나는 것을 생각했을 때 이런식으로 접근할 수 있다
public class JumpAndTeleport {
    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n != 0) {
                if(n % 2 == 0) {
                    n=n/2;
                }
                else {
                    n = n-1;
                    ans++;
                }
            }

            return ans;
        }
    }
}
