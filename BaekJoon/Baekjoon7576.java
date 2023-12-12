package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
*/
// 7576번 : 토마토
// 그래프이론, 너비우선탐색(bfs)
public class Baekjoon7576 {
    // 나의 풀이
    // bfs를 돌리는 것까진 생각했지만 여러개의 시작토마토에서 날짜를 카운팅하는 방법이 안떠올라
    // 코드가 조금 지저분해졌다. 근본적인 풀이방법에서는 벗어나지 않아 테스트결과는 통과
    // 다른 사람의 풀이로 볼때 토마토클래스를 만들어 좌표와 날짜에대한 필드를 만들고
    // bfs를 돌리면서 날짜값을 증가시켜 가장 마지막에 익은 토마토의 날짜값을 리턴
    public static int n, m;
    public static int [][] box;
    public static int [][] ripedBox;
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static ArrayList<Integer> list = new ArrayList<>();
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        for(int i = 0; i < n; i++) {
            String [] temp = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }
        // 조건 중에 토마토가 하나이상이라고 했지 익은토마토가 하나이상이라고는 안했으므로
        // 익은 토마토가 하나도 없다면 즉시 -1 리턴
        if(q.isEmpty()) {
            System.out.println(-1);
        } else {
            ripe(q);
            Loop1 :
            for(int i = 0; i < n; i++) {
                Loop2 :
                for(int j = 0; j < m; j++) {
                    if(ripedBox[i][j] == 0) {
                        list.add(-1);
                        break Loop1;
                    }
                }
            }
            System.out.println(list.get(list.size()-1));
        }

    }

    public static void ripe(Queue<int[]> q) {
        ripedBox = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ripedBox[i][j] = box[i][j];
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            while(!q.isEmpty()) {
                int [] poll = q.poll();
                tmp.add(poll);
            }

            while(!tmp.isEmpty()) {
                int [] temp = tmp.poll();
                int x = temp[0];
                int y = temp[1];

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && ripedBox[nx][ny] == 0) {
                        ripedBox[nx][ny] = 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
            if(!q.isEmpty()) {
                cnt++;
            }
        }

        list.add(cnt);
        return;

    }
}
