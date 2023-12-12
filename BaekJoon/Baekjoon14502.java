package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14502번 : 연구소
// 0 은 빈칸 1은 벽 2는 바이러스
// 새로운 벽은 3개 세울 수 있고 무조건 3개 세워야댐
// 새로운 벽을 세우고 바이러스가 퍼질 수 있는 곳으로 다 퍼지고 남은 빈칸이 안전구역이라고 할 때
// 안전구역의 최대값을 리턴
// 첫째줄 행과 열의 값
// 두번째줄 각좌표에 대한 값
// 너비우선탐색(bfs), 브루트포스 알고리즘, 구현
public class Baekjoon14502  {
    public static int n,m;
    public static boolean [][] visited;
    public static int maxSafeValue = Integer.MIN_VALUE;
    public static int [][] map;
    public static int [][] virusMap;
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // 초기 맵에 정보 넣기
        for(int i = 0; i < n; i++) {
            String [] value = br.readLine().split(" ");
            int [] temp = new int[value.length];
            for(int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(value[j]);
            }
            map[i] = temp;
        }
        makeWall(0);

        System.out.println(maxSafeValue);
    }

    // 벽세우기
    public static void makeWall(int node) {
        if(node == 3) {
            spreadVirus();
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(node + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼트리기, bfs
    public static void spreadVirus() {
        Queue<int[]> q = new LinkedList<>();
        virusMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
                if(virusMap[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int [] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && virusMap[nx][ny] == 0) {
                    virusMap[nx][ny] = 2;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        safeZone(virusMap);
    }

    // 안전구역 값계산(최대값보다 클경우 새로 갱신)
    public static void safeZone(int[][] map) {
        int safeValue = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) {
                    safeValue++;
                }
            }
        }
        if(maxSafeValue < safeValue) {
            maxSafeValue = safeValue;
        }
    }
}
