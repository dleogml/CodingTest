package programmers.level2;

import java.util.*;
// 광물캐기
public class MineralMining {
    class Solution {
        // 5개씩 묶어서 각각 광물갯수를 담을 Section 클래스생성
        public class Section {
            int diamond;
            int iron;
            int stone;
            public void Section(int diamond, int iron, int stone) {
                this.diamond = diamond;
                this.iron = iron;
                this.stone = stone;
            }
            // 각각 광물에 맞게 갯수상승
            public void counting(String s) {
                if(s.equals("diamond")) {
                    diamond++;
                } else if(s.equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }
            // 광물갯수를 담고 있는 배열을 리턴하는 메소드
            public int [] statics() {
                int [] list = {diamond, iron, stone};
                return list;
            }
        }

        // 광물 중요도에 따라 내림차순으로 정렬
        // 다이아많은게 먼저, 그다음 철이 많은거
        public class compareSection implements Comparator<Section> {
            @Override
            public int compare(Section a, Section b) {
                if(a.diamond > b.diamond) {
                    return -1;
                } else if(a.diamond < b.diamond) {
                    return 1;
                } else {
                    if(a.iron > b.iron) {
                        return -1;
                    } else if(a.iron < b.iron) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }

        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int length = (minerals.length / 5) + 1;
            // Section을 담을 배열
            ArrayList<Section> list = new ArrayList<>();
            // 전체곡괭이의 갯수
            int totalPick = 0;
            for(int i : picks) {
                totalPick += i;
            }
            // 5개씩 묶어서 섹션별로 다이아몬드, 철, 돌 갯수를 기록
            // 섹션을 내림차순으로 정렬
            // 앞에서부터 좋은곡괭이를 사용하여 계산된 값 리턴
            /*
            i = 0 ~ 4
                5 ~ 9
                ...
            */
            // 5개의 단위로 끊어서 광물을 담으면서 카운팅
            for(int i = 0; i < minerals.length; i++) {
                if(i % 5 == 0) {
                    Section temp = new Section();
                    int index = i;
                    int count = 0;
                    while(index >= 0 && index < minerals.length && count < 5) {
                        temp.counting(minerals[index]);
                        index++;
                        count++;
                    }
                    list.add(temp);
                }
            }

            // 곡괭이 갯수보다 Section많다면 뒤에 있는 Section은 어차피못캐니까 삭제
            int deleteSection = 0;
            if(totalPick < list.size()) {
                deleteSection = list.size() - totalPick;
                int cnt = 0;
                for(int i = list.size() - 1; cnt < deleteSection; i--) {
                    list.remove(i);
                    cnt++;
                }
            }
            // Section을 내림차순으로 정렬
            Collections.sort(list, new compareSection());

            // 곡괭이종류와 광물갯수에 맞게 누적피로도계산
            int sum = 0;
            for(int i = 0; i < list.size(); i++) {
                int [] tmp = list.get(i).statics();
                if(picks[0] != 0) {
                    sum += tmp[0] + tmp[1] + tmp[2];
                    picks[0]--;
                } else if(picks[1] != 0) {
                    sum += tmp[0] * 5;
                    sum += tmp[1] + tmp[2];
                    picks[1]--;
                } else {
                    sum += tmp[0] * 25;
                    sum += tmp[1] * 5;
                    sum += tmp[2];
                    picks[2]--;
                }
            }

            answer = sum;

            return answer;
        }
    }

    // 처음생각해본 방법
    // 재귀로 경우의 수를 다 계산하는 것을 생각했는데 실패
    // 다시보니 매개변수도 많아지고 재귀이므로 성능면에서도 별로인 것 같다
    public void mineMinerals(int[] temps, int choice, int node, int accumulate, String[] minerals, int[][] point, ArrayList <Integer> list) {
        // choice는 이번에 사용할 곡괭이, node는 진행정도, accumulate는 현재까지계산된값
        /*
        node = 0 => 0 ~ 4 node*5 ~ (node+1) * 5 - 1
        node = 1 => 5 ~ 9
        */
        int [] temp = Arrays.copyOf(temps, temps.length);
        int start = node * 5;
        int end = (node + 1) * 5 - 1;
        temp[choice]--;
        try {
            for(int i = start; i <= end; i++) {
                int index;
                if(minerals[i].equals("diamond")) {
                    index = 0;
                } else if(minerals[i].equals("iron")) {
                    index = 1;
                } else {
                    index = 2;
                }
                accumulate += point[choice][index];
            }
            System.out.println("곡괭이 = " + choice + " 다음 노드 = " + (node+1) + " 현재까지합 = " + accumulate);
            for(int i = 0; i < 3; i++) {
                if(temp[i] != 0) {
                    mineMinerals(temp, i, node+1, accumulate, minerals, point, list);
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            list.add(accumulate);
        }
    }
}
