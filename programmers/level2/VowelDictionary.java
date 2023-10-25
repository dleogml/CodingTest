package programmers.level2;

import java.util.*;

// 5주차 모음사전
public class VowelDictionary {
    class Solution {
        public int solution(String word) {
            int answer = 0;

            ArrayList<String> list = new ArrayList<String>();

            dictionary(0, "A", list);

            boolean flag = false;
            int i=0;

            while(!flag) {
                if(list.get(i).equals(word)) {
                    flag = true;
                }
                i++;
            }

            answer = i;

            return answer;
        }

        public ArrayList dictionary(int node, String alphabet, ArrayList<String> list) {
            if(node == 0) {
                dictionary(node + 1, "A", list);
                dictionary(node + 1, "E", list);
                dictionary(node + 1, "I", list);
                dictionary(node + 1, "O", list);
                dictionary(node + 1, "U", list);
            }
            else if(node !=0 && node != 5) {
                list.add(alphabet);
                dictionary(node + 1, alphabet+"A", list);
                dictionary(node + 1, alphabet+"E", list);
                dictionary(node + 1, alphabet+"I", list);
                dictionary(node + 1, alphabet+"O", list);
                dictionary(node + 1, alphabet+"U", list);
            }
            else {
                list.add(alphabet);
            }
            return list;
        }
    }
}
