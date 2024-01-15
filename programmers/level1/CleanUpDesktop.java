package programmers.level1;

/*
컴퓨터 바탕화면은 각 칸이 정사각형인 격자판입니다. 이때 컴퓨터 바탕화면의 상태를 나타낸 문자열 배열 wallpaper가 주어집니다.
파일들은 바탕화면의 격자칸에 위치하고 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를 (0, 0)으로 시작해
(세로 좌표, 가로 좌표)로 표현합니다. 빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다. 드래그를 하면 파일들을
선택할 수 있고, 선택된 파일들을 삭제할 수 있습니다. 머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서
한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법은 다음과 같습니다.

드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로 이동한 뒤
마우스 왼쪽 버튼을 떼는 행동입니다. 이때, "점 S에서 점 E로 드래그한다"고 표현하고 점 S와 점 E를 각각 드래그의
시작점, 끝점이라고 표현합니다.

점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.

점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이
선택됩니다.

머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper가 매개변수로 주어질 때 바탕화면의 파일들을 한 번에
삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return하는 solution 함수를 작성해 주세요.
드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return하면 됩니다.
*/
// 바탕화면 정리
public class CleanUpDesktop {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int [4];
            int leftX = wallpaper.length;
            int leftY = wallpaper[0].length();
            int rightX = 0;
            int rightY = 0;

            String [][] list = new String[wallpaper.length][wallpaper[0].length()];

            for(int i = 0; i < wallpaper.length; i++) {
                list[i] = wallpaper[i].split("");
            }

            for(int i = 0; i < list.length; i++) {
                for(int j = 0; j < list[0].length; j++) {
                    if(list[i][j].equals("#")) {
                        leftX = Math.min(leftX, i);
                        leftY = Math.min(leftY, j);
                        rightX = Math.max(rightX, i);
                        rightY = Math.max(rightY, j);
                    }
                }
            }

            answer[0] = leftX;
            answer[1] = leftY;
            answer[2] = rightX + 1;
            answer[3] = rightY + 1;

            return answer;
        }
    }
}
