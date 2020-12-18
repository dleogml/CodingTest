package programmers.level1;


import java.util.ArrayList;

// 모의고사
// 수포자들이 3명이 있고 각각의 패턴이 있다
// 1번 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 번호순으로 반복
// 2번 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, ... 2를 하나씩 섞으면서 1,3,2,5 순으로 반복
// 3번 : 3, 3, 1, 1, 2, 2, 2, 4, 4, 5, 5, ... 31245 순으로 반복되는데 두번씩 찍음
// answers에 시험의 정답이 순서대로 담긴 배열 주어지고
// 가장 많이 맞춘 사람을 리턴
// 여럿이라면 전부 리턴하는데 오름차순으로
public class MockTest {
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            // 수포자 3명의 패턴을 저장
            int [] person1 = {1,2,3,4,5};
            int [] person2 = {2,1,2,3,2,4,2,5};
            int [] person3 = {3,3,1,1,2,2,4,4,5,5};

            //각각 점수가 맞았을 때 점수가 증가하는 배열준비
            //int 3개로 대체할수도 있다
            int [] score = new int[3];

            //3명의패턴만큼의 크기로 for문을 돌리고 정답과 비교하여 맞다면 점수증가
            for(int i=0; i<answers.length; i++) {
                if(answers[i] == person1[i%person1.length]) {
                    score[0]++;
                }
                if(answers[i] == person2[i%person2.length]) {
                    score[1]++;
                }
                if(answers[i] == person3[i%person3.length]) {
                    score[2]++;
                }
            }

            //3명중 누가 제일많이 맞췄는지 찾음
            int maxScore = Math.max(Math.max(score[0],score[1]),score[2]);

            //오름차순으로 배열하는 값에 어차피3명이기때문에
            //maxScore와 같다면 1,2,3을 넣어주면 오름차순도 자연스럽게 해결
            ArrayList<Integer> list = new ArrayList<>();
            if(maxScore == score[0]) {list.add(1);}
            if(maxScore == score[1]) {list.add(2);}
            if(maxScore == score[2]) {list.add(3);}

            answer = new int[list.size()];

            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }


            return answer;
        }
    }

}
