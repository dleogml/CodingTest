package programmers.level2;

import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BetweenTwoCircle {
    // 시간초과
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            // 원의 방정식 => (x - a)^2 + (y - b)^2 = r^2
            // x^2 + y^2 = 3^2
            // 2, 1 은 원안에 있다
            // (2-0)^2 + (1-0)^2 < 3^2 특정점에서 중심에서 피타고라스를 통해 거리를 통해 반지름 제곱보다
            // 작으면 원안에 있음
            // 내부원보다 밖에 있고 외부원보다 안에 있는 -r1 < x < r1 , -r2 < y < r2 를 찾고 +8 하면 되지않을까?
            for(int i = -r2 + 1; i < r2; i++) {
                for(int j = -r2 + 1; j < r2; j++) {
                    if(inner(i, j, r1, r2)) {
                        System.out.println(i + " " + j);
                        answer += 1;
                    }
                }
            }

            answer += 4;

            return answer;
        }

        public boolean inner(int x, int y, int r1, int r2) {
            int xValue = Math.abs(x);
            int yValue = Math.abs(y);
            int distance = (int)(Math.pow(xValue, 2) + Math.pow(yValue, 2));
            if((int)Math.pow(r2, 2) >= distance && distance >= (int)Math.pow(r1, 2)) {
                return true;
            }
            return false;
        }
    }

    // 메모리초과
    class Solution2 {
        public long solution(int r1, int r2) {
            int [][] checked = new int [r2 * 2 - 1][r2 * 2 - 1];
            long answer = 0;

            for(int i = -r2 + 1; i < r2; i++) {
                for(int j = r2 - 1; j > -r2; j--) {
                    if(inner(i, j, r1, r2) && checked[r2-1-Math.abs(j)][r2-1-Math.abs(i)] == 0) {
                        System.out.println(i + " " + j);
                        samePosition(checked, i, j, r2);
                        //answer += 4;
                    }
                }
            }

            //answer += 4;
            for(int i = 0; i < checked.length; i++) {
                List<Integer> intList
                        = Arrays.stream(checked[i])
                        .boxed()
                        .collect(Collectors.toList());
                answer += Collections.frequency(intList, 1);
            }

            answer += 4;

            return answer;
        }

        public boolean inner(int x, int y, int r1, int r2) {
            int xValue = Math.abs(x);
            int yValue = Math.abs(y);
            int distance = (int)(Math.pow(xValue, 2) + Math.pow(yValue, 2));
            if((int)Math.pow(r2, 2) >= distance && distance >= (int)Math.pow(r1, 2)) {
                return true;
            }
            return false;
        }

        public int[][] samePosition(int [][] checked, int x, int y, int r2) {
            // 0,0 0,4 4,0 4,4
            // 1,0 1,4 3,0 3,4
            // 0,1 4,0 0,3 4,3
            int degree = r2 - 1;
            int row = degree - Math.abs(y);
            int column = degree - Math.abs(x);

            if(r2 % 2 == 1 && row == r2 - 1 && column == 0) {
                checked[row][column] = 1;
                checked[row][degree + Math.abs(x)] = 1;
                System.out.println("2개추가");
            } else if(r2 % 2 == 1 && row == 0 && column == r2 - 1) {
                checked[row][column] = 1;
                checked[degree + Math.abs(y)][column] = 1;
                System.out.println("2개추가");
            } else {
                checked[row][column] = 1;
                checked[row][degree + Math.abs(x)] = 1;
                checked[degree + Math.abs(y)][column] = 1;
                checked[degree + Math.abs(y)][degree + Math.abs(x)] = 1;
                System.out.println("4개추가");
            }

            return checked;
        }
    }

    // 다른 사람의 풀이
    /*
    원점이 0이므로 원의 방정식은 x^2 + y^2 = r^2 이다
    r^2 - x^2 = y^2 이 되므로 y = 루트(r^2 - x^2) 이고 이는 곳 해당 x좌표에서 원안에 속하는 y의 개수를 의미
    올림과 내림을 하는 이유는
    작은 원의 y의 개수가 1.xxx라면 y는 0인경우까지 2개이므로 올림을 해줌
    큰 원의 y의 개수가 2.xx라면
    */
    class Solution3 {
        public long solution(int r1, int r2) {
            long answer = 0;

            for (int i = 1; i <= r2; i++) {
                int start = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
                int end = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
                System.out.println(i + " " + end + " " + start);

                answer += end - start + 1;
            }

            answer *= 4;


            return answer;
        }
    }
}
