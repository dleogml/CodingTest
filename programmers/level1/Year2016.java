package programmers.level1;

// 1월 1일은 금요일이다
// 2016년은 윤달이므로 29일까지 있다
public class Year2016 {
    public String solution(int a, int b) {
        String answer = "";
        int totalDay = 0;
        int dayOfMonth = 0;
        // 현재 월 이전까지의 일수
        for(int i=1; i<a; i++) { // @1
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8  || i == 10 || i == 12) dayOfMonth = 31;
            else if(i == 2) dayOfMonth = 29;
            else dayOfMonth = 30;

            totalDay += dayOfMonth;
        }

        //현재월의 일수를 추가로 더함
        totalDay += b; // @2

        //7로 나눠서 해당하는 요일값 answer에 넣어주기
       // @3
        switch(totalDay % 7) {
            case 0:
                answer = "THU";
                break;
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;

        }

        return answer;
    }
}
