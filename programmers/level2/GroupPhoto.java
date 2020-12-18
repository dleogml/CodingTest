package programmers.level2;

import java.util.HashMap;

// 단체사진 찍기
// 8명이 단체사진을 찍는데 조건의 개수 n과 조건이 담긴 data가 주어진다
// 첫번째와 세번째에는 글자가 주어지고 두번째는 무조건 ~이다
// 네번째는 {=, <, >}이다
// 다섯번째는 0이상 6이하의 정수형 문자이고 둘사이의 간격을 의미한다
// 간격은 둘 사이에 있는 사람의 수
// 모든 조건을 만족하는 경우의 수를 리턴
public class GroupPhoto {
    class Solution {
        public int solution(int n, String[] data) {

            // 캐릭터마다 새로운 번호를 매칭
            hm = new HashMap<Character, Integer>();
            hm.put('A', 0);
            hm.put('C', 1);
            hm.put('F', 2);
            hm.put('J', 3);
            hm.put('M', 4);
            hm.put('N', 5);
            hm.put('R', 6);
            hm.put('T', 7);

            permute = new int[8];
            selected = new boolean[8];
            count = 0;

            // dfs ( pos, data ): pos번째 캐릭터 위치를 정하고, pos+1 번째 구하고.. 끝까지! 순열 구한다
            // 그리고 조건data를 통과하는지 확인
            dfs(0,  data);

            return count;
        }

        HashMap<Character, Integer> hm;
        //순열을 위한 배열
        int[] permute ;
        boolean[] selected ;
        int count;

        // permute에서 pos번째 케릭터의 위치를 고른다.
        public void dfs(int pos, String[] data) {

            if(pos == 8) { // 하나의 permute이 완성
                char compare;
                int c1, c2, digit;
                for(int i = 0 ; i < data.length ; i++) {
                    c1 = permute[hm.get(data[i].charAt(0))];
                    c2 = permute[hm.get(data[i].charAt(2))];
                    compare = data[i].charAt(3);
                    // char 숫자를 int로 바꿀 때 '0'을 빼주면 쉽다
                    digit = data[i].charAt(4)-'0';
                    // 붙어있는경우가 간격이 0이기 때문에 기본적으로 -1을 해줘야 함
                    if(compare == '>') {
                        if(Math.abs(c1-c2) -1 <= digit)
                            return;
                    }else if(compare == '<') {
                        if(Math.abs(c1-c2) -1  >= digit)
                            return;
                    }else {
                        if(Math.abs(c1-c2) - 1 != digit)
                            return;
                    }
                }
                count++;
                return;
            }

            // pos번째 캐릭터가 위치 가능한 모든 i
            for(int i = 0 ; i < 8 ; i++) {
                if(!selected[i]) {
                    selected[i] = true;
                    permute[pos] = i;
                    dfs(pos+1, data);
                    selected[i] = false;
                }
            }
        }
    }
}
