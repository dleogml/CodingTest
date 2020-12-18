package programmers.level1;

// 다트 게임
// 총 3번의 기회로 구성되고 각각 점수는 0~10점
// 점수와 함께 S:single, S:double, T:triple이 주어지고 각각 점수의 제곱을 의미한다
// * : 스타상, # : 아차상이 주어지고 스타상은 그점수와 이전점수를 두배만들고 아차상은 해당점수를 마이너스로 만든다
// 제곱은 무조건 점수마다 있고 스타상과 아차상은 있을수도 있고 없을수도 있다
// String이 주어지면 점수를 계산해서 리턴
public class Dart {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            // 점수를 담을 배열, 배열 index용 변수와 주어진점수를 추출할 String 변수
            int[] score = new int[3];
            int id = 0;
            String temp = "";

            for(int i=0; i<dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                // 추출한게 점수라면 temp에 스트링으로 저장
                if(c >= '0' && c <= '9') {
                    temp += String.valueOf(c);
                }
                // 제곱이 나오면 temp를 int변수로 바꾸고 제곱시켜 다시 저장
                // 이를 점수 배열에 넣으면서 id증가 temp 초기화
                else if(c == 'S' || c == 'D' || c == 'T') {
                    int p = Integer.parseInt(temp);

                    if(c == 'S') {
                        p = (int)Math.pow(p,1);
                    }
                    else if(c == 'D') {
                        p = (int)Math.pow(p,2);
                    }
                    else {
                        p = (int)Math.pow(p,3);
                    }

                    score[id++] = p;
                    temp = "";
                }
                // id가 증가 되있기때문에 -1 처리
                // #이 나오면 -1을 시키고
                // *가 나오면 우선 그 점수를 두배시키고
                // id-2>=0 즉 두번째나 세번째라면 그것보다 하나 앞인
                // id-2를 두배시킨다.
                else {
                    if(c == '#') {
                        score[id -1] *= -1;
                    }
                    else {
                        score[id -1] *= 2;
                        if(id -2 >= 0) {
                            score[id -2] *= 2;
                        }
                    }
                }
            }

            // 점수배열의 값들을 전부더함
            for(int val : score) {
                answer += val;
            }

            return answer;
        }
    }
}
