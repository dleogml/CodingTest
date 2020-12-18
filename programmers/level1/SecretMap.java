package programmers.level1;

// 비밀지도
// 길이가 n인 정사각형 배열이고 지도1,지도2가 주어지고
// 지도1과 지도2의 숫자는 2진수로 표현했을시 1="#" 0=공백으로 표현되는 지도이다
// 두 지도를 합쳐서 나오는 지도가 비밀지도이고
// 둘다 공백일 경우만 공백이고 나머지는 1로 합쳐진다
// 비밀지도는 #과 공백으로 이루어진 배열로 표현해서 리턴
public class SecretMap {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            // toBinaryString 은 10진수를 2진수로 표현
            // 비트연산자인 |를 사용하게 되면 두 2진수를 비교하여
            // 하나라도 1이면 1로 둘다0일 경우만 0으로 변환
            for(int i=0; i<n; i++) {
                answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            }

            // n의 길의 문자열을 넣고
            // 1은 #로 0은 공백으로 대체
            for(int i=0; i<n; i++) {
                answer[i] = String.format("%"+n+"s", answer[i]);
                answer[i] = answer[i].replace("1", "#");
                answer[i] = answer[i].replace("0", " ");
            }

            return answer;
        }
    }
}
