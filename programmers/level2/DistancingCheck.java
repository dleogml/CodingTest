package programmers.level2;

// 거리두기 확인
/*
1. 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
2. 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
3. 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
** 맨해튼거리 : 두점(x1, y1), (x2, y2)의 맨해튼거리는 |x1-y1| + |x2-y2| 이다.
응시자가 앉아있는 자리 : P
빈 테이블 : O
파티션(벽) : x

자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 places가 매개변수
places의 행의 길이(대기실 개수) = 5
대기실마다 모든 응시자들이 거리두기를 지키고 있으면 1, 한명이라도 지키지 않고 있으면 0을 리턴
*/
public class DistancingCheck {
    class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            // places의 원소하나가 방하나의 정보
            // P, 즉 사람일때 주변탐색
            // 하나라도 거리두기실패하면 그 방은 for문종료
            for(int k=0; k<places.length; k++) {
                boolean flag = false;
                String[] map = places[k];
                for(int i=0; i<5; i++) {
                    for(int j=0; j<5; j++) {
                        if(map[i].charAt(j) == 'P') {
                            if(checkDistance(i, j, map)) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag) {
                        answer[k] = 0;
                        break;
                    }
                }
                if(!flag) {
                    answer[k] = 1;
                }
            }

            return answer;
        }
        // P일경우 주변에 다른 사람탐색
        public boolean checkDistance(int i, int j, String[] map) {
            // 각각 상하좌우 한칸, 상하좌우 2칸, 대각선 1칸
            int[] pi = {0, 0, 1, -1};
            int[] pj = {1, -1, 0, 0};

            int[] pi2 = {0, 0, 2, -2};
            int[] pj2 = {2, -2, 0, 0};

            int[] pi3 = {1, 1, -1, -1};
            int[] pj3 = {1, -1, 1, -1};

            // 상하좌우 1칸, 이 위치에 다른 사람이 있으면 거리두기실패
            for(int d=0; d<4; d++) {
                int mi = i + pi[d];
                int mj = j + pj[d];
                if(mi < 0 || mi >= 5 || mj < 0 || mj >= 5) continue;
                if(map[mi].charAt(mj)=='P') return true;
            }

            // 상하좌우 2칸, 이 위치에 다른 사람이 있고 그 사이에 X가 아닐경우 거리두기실패
            for(int d=0; d<4; d++) {
                int mi = i + pi2[d];
                int mj = j + pj2[d];
                if(mi < 0 || mi >= 5 || mj < 0 || mj >= 5) continue;
                if(map[mi].charAt(mj)=='P') {
                    if(map[(i+mi)/2].charAt((j+mj)/2) != 'X') {
                        return true;
                    }
                }
            }

            // 대각선 1칸, 이 위치에 다른 사람이 있고 2x2의 나머지 대각선2칸이
            // X가 아닐경우 거리두기실패
            for(int d=0; d<4; d++) {
                int mi = i + pi3[d];
                int mj = j + pj3[d];
                if(mi < 0 || mi >= 5 || mj < 0 || mj >= 5) continue;
                if(map[mi].charAt(mj)=='P') {
                    if(!(map[i].charAt(mj)=='X' && map[mi].charAt(j)=='X')) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
