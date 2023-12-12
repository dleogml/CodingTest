package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는
A+B 번의 비교를 해야 한다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.

매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면,
고르는 순서에 따라서 비교 횟수가 매우 달라진다. 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤,
합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 그러나 10장과 40장을 합친 뒤,
합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.

N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.
*/
// 1715번 : 카드 정렬하기
// 최소가 될때의 비교값을 리턴
// 작은것부터 정렬
// 먼저 앞에 두개를 더해서(정렬했으므르 가장작은 두개) 결과를 저장 후(더한값만 저장하는배열) 두개는 배열에서 제외, 결과값은 배열에 새로 저장
// 다시 가장 작은것 두개를 더해서 저장 후(더한값만 저장하는배열) 두개 제외, 결과값 배열에 저장
// 우선순위 큐를 이용하면 쉽게 해결
// 큐에 새로운 값 입력하고 추출하는 과정에서 알아서 최소값이 추출됨
// 최악의 경우를 생각해서(N일경우 Integer 범위초과) long을 써야 한다는 것을 주의해야한다
// 그리디, 우선순위 큐
public class Baekjoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            long card = Long.parseLong(br.readLine());
            pq.offer(card);
        }

        long sum = 0;
        while(pq.size() > 1) {
            long cards1 = pq.poll();
            long cards2 = pq.poll();
            long result = cards1 + cards2;
            sum += result;
            pq.offer(result);
        }

        System.out.println(sum);

    }
}
