package programmers.level1;

import java.util.Scanner;

// 직사각형 별찍기
// a, b를 입력받아서 한행에 a만큼의 별찍고 b만큼의 행을 가진 별찍기
public class RectangleStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
