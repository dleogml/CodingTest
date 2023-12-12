package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//모래시계 모양으로 별찍기
public class Baekjoon2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        for(int i=2*n-1; i>0; i--) {
//            if (i % 2 !=0 ) {
//                for(int k=0; k<i; k++) {
//                    System.out.print(" ");
//                }
//                for(int j=1; j<=i; j++) {
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//            else continue;
//        }
//        for(int i=3; i<=2*n-1; i++) {
//            if (i % 2 != 0) {
//                for(int j=1; j<=i; j++) {
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//            else continue;
//        }

        for(int i=0;i<n;i++) { // 빈 칸의 개수가 +1씩 증가하므로 0부터 4까지 반복해준다.
            for(int j=1;j<2*n;j++) { // 열의 개수는 동일하므로 고정한다.
                if(j ==2 * n -i) break; // 이는 출력형식 오류를 방지하기 위해서 수행해준다.
                // 즉, 별을 다 찍으면 반복문을 벗어나 다음 행으로 간다.
                if(j > 0+i && j<2*n-i) { // 해당 범위안에서만 별을 찍어준다.
                    System.out.print("*");
                }else // 나머지는 공백 처리
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=1;i<n;i++) { // 아랫 부분의 반복 범위의 표현을 위해 1~4반복
            for(int j=1;j<2*n;j++) { // 열은 고정
                if(j>n+i) break; // 마찬가지로 마지막 별을 찍은 다음 반복은 수행하지 않는다.
                if(j>= n-i && j<=n+i) { // 해당 범위에 별을 찍기 각 범위가 양쪽에서 1씩 증가하므로
                    // 한 줄이 넘어갈 때 마다 2개씩 별이 더 찍히게 된다.
                    System.out.print("*");
                }else // 나머지는 공백처리
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
