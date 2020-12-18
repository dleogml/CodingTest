package programmers.level2;

// 전화번호 목록
// 전화번호 여러개가 적힌 전화번호 목록이 주어지고
// 어떤 전화번호가 다른 번호의 접두어라면 false, 아니라면 true를 리턴
public class PhoneNumberList {
    // startsWith를 이용한 풀이
    // String1.startsWith(String2)는 String1이 String2로 시작하는지 체크하는 함수
    // 맞다면 true, 아니라면 false를 리턴
    class Solution {
        public boolean solution(String[] phoneBook) {
            for(int i=0; i<phoneBook.length-1; i++) {
                for(int j=i+1; j<phoneBook.length; j++) {
                    if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                    if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
                }
            }
            return true;
        }
    }
    // 다른 사람의 풀이(indexOf를 이용)
    // 다른문자의 indexOf를 비교문자로 해서 값이 0이라면
    // 그 문자로 시작한다는 뜻이므로 접두어임
    class Solution2 {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            for(int i =0; i<phone_book.length; i++){
                for(int j =0; j<phone_book.length; j++){
                    if(i == j) continue;
                    if(phone_book[j].indexOf(phone_book[i])==0){//접두어라면
                        return false;
                    }
                }
            }

            return answer;
        }
    }
}
