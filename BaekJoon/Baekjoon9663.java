package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (1 ≤ N < 15)

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
*/
// 9663번 : N-Queen
// 브루트포스 알고리즘, 백트래킹
public class Baekjoon9663 {
    /*
    1차원배열로 2차원배열을 표현하는게 핵심
    길이가 n인 배열을 만들고 배열의 인덱스를 행으로 보고
    각 인덱스에 해당하는 값을 열로 봄
    예를 들어 길이가 5인 배열 array = {0, 3, 1, 4, 2} 라면
    첫번째행은 첫번째열에 퀸을 놓은것이고
    두번째행은 네번째열에 퀸을 놓은것이다
    나머지 행들도 같은 방식으로 이해
    */
    public static int n;
    public static int [] map;
    public static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int [n];

        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int node) {
        // 8개를 다 성공적으로 놓았다면 중지하고 경우의 수 하나증가
        if(node == n) {
            count++;
            return;
        }
        // 첫번째 행부터 열을 하나씩 증가시키면서 놓고 경우의 찾기
        for(int i = 0; i < n; i++) {
            map[node] = i;
            
            // 둘 수 있다면 그 다음 행에 새로운 퀸놓기 시작
            if(check(node)) {
                dfs(node+1);
            }
        }
    }
    // 현재 놓은 곳이 이전에 놓은 곳은 다른행들과 겹치지 않는지 체크
    // 기본적으로 행이 다르므로 가로는 체크하지않아도 되고 세로와 대각선만 체크
    public static boolean check(int node) {
        // 첫번째 행부터 현재행전까지 탐색
        for(int i = 0; i < node; i++) {
            // 이전행과 같은 열에 놓았다면 둘 수 없다
            if(map[node] == map[i]) {
                return false;
            // 대각선에 위치해 있는걸 체크
            // 행의 차이와 열의 차이가 같으면 대각선에 위치해있는것이고 둘 수 없다
            } else if(Math.abs(node - i) == Math.abs(map[node] - map[i])) {
                return false;
            }
        }
        return true;
    }

    /*
    public static int [][] map;
    public static boolean [][] visited;
    public static int n;
    public static int count = 0;

    나의 풀이
    이중for문때문에 시간도 배로 걸리고 값도 정확하게 리턴되지 않았다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        if(n <= 3) {
            System.out.println(0);
        } else {
            dfs(0);
            System.out.println(count);
        }
    }
    public static void dfs(int node) {
        if(node == n) {
            count++;
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    if(check(i, j)) {
                        visited[i][j] = true;
                        dfs(node + 1);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] && ( i == x || j == y || (Math.abs(x-i) == Math.abs(y-j)) ) ) {
                    return false;
                }
            }
        }
        return true;
    }
    */
}
