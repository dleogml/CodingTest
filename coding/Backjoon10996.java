package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//지그재그로 별도 찍고 그만큼 길이도 늘어남
public class Backjoon10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 총 나타나는 행은 2n
        for(int i=1; i<=2*n; i++ ) {
            //홀수번째 행일때
            if(i % 2 == 1) {
                //별 공백 별 ... 이런식으로 출력
                for(int j=1; j<=n; j++) {
                    if(j % 2 == 1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }

            }
            //짝수번째 행일때
            else {
                //공백 별 공백 ... 이런식으로 출력
                for(int j=1; j<=n; j++) {
                    if(j % 2 ==1) {
                        System.out.print(" ");
                    }
                    else {
                        System.out.print("*");
                    }
                }
            }
            System.out.print("\n");

        }

    }
}
