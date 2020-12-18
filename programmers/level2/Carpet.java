package programmers.level2;

import java.util.ArrayList;

// 카펫
// 갈색칸의 숫자와 노란색칸의 숫자가 주어지고 노란색은 무조건 가운데에 위치
// 이 경우를 만족하는 가로의 길이와 세로의 길이를 크기2짜리 배열에 담아서 리턴
// 가로의 길이는 세로의 길이보다 같거나 크다
// 가로의 길이가 m 세로의 길이가 n이라고 가정할 경우
// 둘레의 칸수는 2 * m + 2 * (n - 2) = brown 이 성립된다.
// 칸수이기 때문에 가로의 칸수를 셀때 모서리를 세로에선 세면 안되므로 n - 2
// yellow도 생각해보면 가로에서 2칸 세로에서 2칸 뺀 크기의 가로세로길이를 가지므로
// yellow = (m - 2) * (n - 2)
// brown : 8이상 5000이하, yellow : 1이상 2,000,000이하 이므로 가장 작을때의 세로의 길이가 3이다.
public class Carpet {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int sum = (brown + 4) / 2;
            int n = 3;
            int m = sum - n;

            while(m >= 3 && m >= n) {
                if((m -2) * (n -2) == yellow) {
                    answer[0] = m;
                    answer[1] = n;
                    break;
                }
                m--; n++;
            }

            return answer;
        }
    }
}
