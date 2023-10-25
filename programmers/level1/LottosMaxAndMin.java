package programmers.level1;

// 로또의 최고 순위와 최저 순위
/*
내 번호 lottos[]와 당첨번호 win_nums[]가 주어짐
내 번호중에 0은 알 수 없는 번호로 이 번호 경우의 수에 따라
최고 순위와 최저 순위를 answer[]로 리턴
1등 6개번호일치
2등 5개번호일치
3등 4개번호일치
4등 3개번호일치
5등 2개번호일치
6(낙첨) 그외
*/
public class LottosMaxAndMin {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            int rightCnt = 0;
            int zeroCnt = 0;
            for(int i=0; i<6; i++) {
                if(lottos[i] == 0) {
                    zeroCnt++;
                }
                for(int j=0; j<6; j++) {
                    if(lottos[i] == win_nums[j]) {
                        rightCnt++;
                    }
                }
            }
            // 다른 사람의 풀이
            // 변수 2개 구하는 것까지는 같았지만
            // min을 이용해서 훨씬 보기좋게 등수를 정함
            /*
            int min = matched;
            int max = matched + zero;
            int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
            */
            switch(rightCnt) {
                case 0:
                case 1:
                    answer[1] = 6;
                    break;
                case 2:
                    answer[1] = 5;
                    break;
                case 3:
                    answer[1] = 4;
                    break;
                case 4:
                    answer[1] = 3;
                    break;
                case 5:
                    answer[1] = 2;
                    break;
                case 6:
                    answer[0] = 1;
                    answer[1] = 1;
                    break;
            }
            switch (rightCnt + zeroCnt) {
                case 0:
                case 1:
                    answer[0] = 6;
                    break;
                case 2:
                    answer[0] = 5;
                    break;
                case 3:
                    answer[0] = 4;
                    break;
                case 4:
                    answer[0] = 3;
                    break;
                case 5:
                    answer[0] = 2;
                    break;
                case 6:
                    answer[0] = 1;
                    break;
            }

            return answer;
        }
    }
}
