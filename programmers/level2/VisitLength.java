package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 방문 길이
/*
U, D, R, L 네가지 명령어가 있고 위, 아래, 오른쪽, 왼쪽으로 한칸씩 가는 명령어이다.
좌표는 X,Y가 5부터 -5까지인 평면이고 (0,0)에서 출발한다
명령어대로 움직이지만 좌표를 넘어간 명령어는 무시하고 처음 걸어본 길의 길이만 구해서 리턴
*/
public class VisitLength {
    class Solution {
        // U,D,R,L - 위,아래,오른쪽,왼쪽 순
        // 2차원배열(행렬)이므로 위로 갈 때 y가 줄어듬
        public int[] dx = {0, 0, 1, -1};
        public int[] dy = {-1, 1, 0, 0};
        // 맵의 크기 = -5 ~ 5까지이므로 11x11
        public boolean[][][][] visit = new boolean[11][11][11][11];

        public int solution(String dirs) {
            int answer = 0;

            /* x,y = 캐릭터가 이동하기 전 위치, nextX, nextY = 캐릭터가 이동한 후 위치 */
            int x = 0;
            int y = 0;
            // 문제의 범위는 -5~5이고, 배열의크기는0~10이므로 시작 위치를 +5로 잡아준다.
            int nextX = 5;
            int nextY = 5;

            int index = 0;

            for(int i=0; i<dirs.length(); i++){
                // 캐릭터의 현재 위치 저장
                x = nextX;
                y = nextY;
                if(dirs.charAt(i) == 'U')
                    index = 0;
                else if(dirs.charAt(i) == 'D')
                    index = 1;
                else if(dirs.charAt(i) == 'R')
                    index = 2;
                else if(dirs.charAt(i) == 'L')
                    index = 3;

                // U, D, R, L에 맞는 캐릭터 위치 이동
                nextX += dx[index];
                nextY += dy[index];

                // 이전에 움직인 범위에 의해 캐릭터의 위치가 지도를 벗어났을 경우
                if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10){
                    // 다시 캐릭터를 전의 위치로 이동
                    nextX -= dx[index];
                    nextY -= dy[index];
                    continue;
                }

                // 캐릭터가 처음 걸어본 길일경우
                // 시작점과끝점, 끝점과시작점으로 지난간 길이를 표시
                if(!visit[x][y][nextX][nextY] && !visit[nextX][nextY][x][y]){
                    // 걸어온 길 체크(점이 아닌 길이기 때문에 양방향으로 체크한다.)
                    visit[x][y][nextX][nextY] = true;
                    visit[nextX][nextY][x][y] = true;
                    answer ++;
                }
            }
            return answer;
        }
    }
    // 다른 사람의 풀이
    // HashMap과 HashSet을 이용해서 풀이
    // HashMap에 상하좌우 움직임에 대한 좌표값을 넣고
    // 명령에 해당하는 시작점과 끝점 생성(좌표넘어가면 다시 뒤로 무르고 건너뜀)
    // HashSet으로 시작점과 끝점으로 지나간 곳을 표시(중복제거 이용)
    // 길이표시를 위해 시작점, 끝점을 2개씩 넣었으니 set 크기의 절반이 정답
    class Solution2 {
        public int solution(String dirs) {
            Map<String, int[]> map = new HashMap<>();
            map.put("U", new int[] {0, 1});
            map.put("D", new int[] {0, -1});
            map.put("R", new int[] {1, 0});
            map.put("L", new int[] {-1, 0});

            String[] arr = dirs.split("");

            Set<String> set = new HashSet<>();
            int cx = 0;
            int cy = 0;

            for(int i=0; i<arr.length; i++) {
                String s = arr[i];

                int x = map.get(s)[0];
                int y = map.get(s)[1];

                cx += x;
                cy += y;

                if(cx < -5 || cx > 5) {
                    cx -= x;
                    continue;
                }
                if(cy < -5 || cy > 5) {
                    cy -= y;
                    continue;
                }
                set.add(""+(cx-x)+ ""+ (cy-y)+ ""+cx + ""+cy);
                set.add(""+cx + ""+cy+""+(cx-x)+ ""+ (cy-y));
            }
            return set.size()/2;
        }
    }
}
