package programmers.level1;

// 키패드 누르기
/* 1 2 3
   4 5 6
   7 8 9
   * 0 #

   이런식으로 키패드가 있고
   147은 왼손 369는 오른손으로 누르고
   2580은 두손 중 가까운손, 만약 거리가 같다면 오른손잡이면 오른손, 왼손잡이면 왼손으로 누른다
   왼손은 *에서 시작 오른손은 #에서 시작
   숫자 배열이 주어졌을 때 왼손으로 눌렀으면 L, 오른손으로 눌렀으면 R로 표기하여 리턴
 */
public class Keypad {
    static class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder bd = new StringBuilder();

            // 초기 각손의 위치 *=10 #=12
            int leftLocation = 10;
            int rightLocation = 12;

            // 배열에 들어오는 숫자에 따라 StringBuilder에 넣어줌
            for(int number : numbers) {
                // 1,4,7일때는 왼손 그리고 왼손의 위치를 해당 숫자로 변경
                if(number == 1 || number == 4 || number == 7) {
                    bd.append("L");
                    leftLocation = number;
                }
                // 3,6,9일때는 오른손 그리고 오른손의 위치를 해당 숫자로 변경
                else if(number == 3 || number == 6 || number == 9) {
                    bd.append("R");
                    rightLocation = number;
                }
                // 2,5,8,0일때
                else {
                    // 해당숫자와 현재 왼손, 오른손과의 거리
                    int distanceL = getDist(leftLocation, number);
                    int distanceR = getDist(rightLocation, number);

                    // 왼손이 더 멀다면 오른손으로 누르고
                    // 오른손이 더 멀다면 왼손으로 누른다
                    // 만약에 같다면 어떤 손잡이인지 비교해 누름
                    if(distanceL > distanceR) {
                        bd.append("R");
                        rightLocation = number;
                    }else if(distanceL < distanceR) {
                        bd.append("L");
                        leftLocation = number;
                    }else {
                        if(hand.equals("right")) {
                            bd.append("R");
                            rightLocation = number;
                        }else {
                            bd.append("L");
                            leftLocation = number;
                        }
                    }
                }
            }

            // String으로 바꿔 리턴
            return bd.toString();
        }

        // 주어진 배열과 왼손과 오른손 사이의 거리를 구하기 위한 메소드
        public static int getDist(int location, int number) {
            // 0은 11로 생각하고 계산
            if(number == 0) {
                number = 11;
            }

            if(location == 0) {
                location = 11;
            }

            // 각각 숫자의 위치를 2차원 배열로 생각해서
            // 1을 (0,0) 12(#)를 (3,2)로 생각
            // 숫자에서 1을 빼면 3으로 나눈 몫의 값으로 x좌표를 구하고
            // 나머지값을 y좌표로 구하면
            // 왼쪽열은 y가 0, 중간은 1, 오른쪽은 2가 됨
            // x는 0행부터 3행까지 존재
            // 좌표를 통해 왼손과 눌러야 할 숫자
            // 오른손과 눌러야 할 숫자를 구할 메소드를 완성
            int locationX = (location-1) / 3;
            int locationY = (location-1) % 3;

            int numberX = (number-1) / 3;
            int numberY = (number-1) % 3;

            // Math.abs()는 절대값
            return Math.abs(locationX-numberX) + Math.abs(locationY - numberY);
        }
    }
}
