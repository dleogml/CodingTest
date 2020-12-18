package programmers.level2;

// 스킬트리
// 스킬트리의 순서가 적힌 skill과
// 유저들이 짠 스킬트리가 담겨져 있는 skill_trees가 주어지면
// 선행스킬순서를 올바르게 지킨 스킬트리의 개수를 리턴
// 스킬트리와 관계없는 스킬의 위치는 상관없다
public class SkillTree {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            // 처음엔 다 가능하다고 가정
            // 이후 밑에 과정을 통해 불가능한 스킬트리를 뺌
            int answer = skill_trees.length;
            // 스킬의 순서를 저장할 변수
            int beforeIdx, currentIdx = 0;

            for(int i=0; i<skill_trees.length; i++) {
                // 첫번째 스킬의 위치가 스킬트리에 몇번째에 있는가 저장
                beforeIdx = skill_trees[i].indexOf(skill.charAt(0));

                // 그 다음 두번째 스킬의 위치를 저장하여 비교
                // 불가능하다면 for문을 더 돌릴필요가 없으므로 중단
                // 가능하다면 두번째스킬을 비교할 기준으로 만들고 그 다음 스킬을 비교
                for(int j=1; j<skill.length(); j++) {
                    currentIdx = skill_trees[i].indexOf(skill.charAt(j));

                    if( (beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1) ) {
                        answer--;
                        break;
                    }

                    beforeIdx = currentIdx;
                }
            }

            return answer;
        }
    }

    // 다른 사람의 풀이(정규식을 이용)
    class Solution2 {
        public int solution2(String skill, String[] skill_trees) {
            int answer = skill_trees.length;

            for(int i=0; i< skill_trees.length; i++) {
                if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))!=0) {
                    answer--;
                }
            }
            return answer;
        }
    }
}
