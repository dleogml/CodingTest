package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 오픈채팅방
// record라는 문자열 배열이 주어지고 문자열엔 다음과같은 내용이 담겨져있다.
/*
모든 유저는 [유저 아이디]로 구분한다.
[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - Enter [유저 아이디] [닉네임] (ex. Enter uid1234 Muzi)
[유저 아이디] 사용자가 채팅방에서 퇴장 - Leave [유저 아이디] (ex. Leave uid1234)
[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - Change [유저 아이디] [닉네임] (ex. Change uid1234 Muzi)
첫 단어는 Enter, Leave, Change 중 하나이다.
각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
*/
// 이를 오픈채팅방에 맞게 메세지로 바꿔서 리턴
public class OpenChattingRoom {
    class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};
            HashMap<String, String> hm = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();

            // change일경우 길이가 2이기때문에 패스
            // enter와 leave일 경우 유저아이디와 닉네임을 HashMap에 저장
            // 어차피 최종 닉네임으로 보이기때문에 HashMap에 유저아이디로 구분해서
            // 닉네임을 저장하면 같은key의 value는 덮어써지는 걸 이용
            for(int i=0; i<record.length; i++) {
                String[] temp = record[i].split(" ");
                if(temp.length < 3) {
                    continue;
                }
                hm.put(temp[1],temp[2]);
            }

            // 명령어에 맞게 값과 메세지를 조합해서 ArrayList에 저장
            // change면 패스
            for(int i=0; i<record.length; i++) {
                String[] temp = record[i].split(" ");
                if(temp[0].equals("Enter")) {
                    list.add(hm.get(temp[1]) + "님이 들어왔습니다.");
                }
                else if(temp[0].equals("Leave")) {
                    list.add(hm.get(temp[1]) + "님이 나갔습니다.");
                }
                else {
                    continue;
                }
            }
            // answer 배열로 옮기기
            answer = new String[list.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    // 다른 사람의 풀이
    public String[] solution(String[] record) {
        HashMap<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for(String str:record){
            String[] split = str.split("\\s+");
            String code = split[0];
            String uid = split[1];
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }
            if(!"Change".equalsIgnoreCase(code)){
                list.add(code +" "+uid);
            }

        }
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            String[] split = list.get(i).split("\\s+");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
    }
}
