package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 방금 그곡
/*
방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
음악이 00:00를 넘겨서까지 재생되는 일은 없다.
조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
 */
// 멜로디를 담은 문자열 m과 방송된 곡의 정보를 담고 있는 배열 musicinfos가 주어진다
/*
m은 음 1개 이상 1439개 이하로 구성되어 있다.
musicinfos는 100개 이하의 곡 정보를 담고 있는 배열로, 각각의 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보가 ','로 구분된 문자열이다.
음악의 시작 시각과 끝난 시각은 24시간 HH:MM 형식이다.
음악 제목은 ',' 이외의 출력 가능한 문자로 표현된 길이 1 이상 64 이하의 문자열이다.
악보 정보는 음 1개 이상 1439개 이하로 구성되어 있다.
*/
// 해당 정보를 바탕으로 원하는 곡을 찾아 제목을 리턴
public class ThatSongJustNow {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            music[] musics = new music[musicinfos.length]; // 곡 정보
            m = sheetReplace(m); // # -> 소문자
            ArrayList<music> list = new ArrayList<>();

            for(int i=0; i<musicinfos.length; i++) {
                int hour = Integer.parseInt(musicinfos[i].substring(6,8))
                        - Integer.parseInt(musicinfos[i].substring(0,2));
                int minute = Integer.parseInt(musicinfos[i].substring(9,11))
                        - Integer.parseInt(musicinfos[i].substring(3,5));
                int len = hour * 60 + minute; // 음악 길이

                String title = musicinfos[i].split(",")[2];
                String sheet = sheetReplace(musicinfos[i].split(",")[3]);

                String play = "";
                // 음악길이가 코드보다 길다면 반복해서 더해줌
                if(sheet.length() < len) {
                    int n1 = len/sheet.length(); // 몫
                    int n2 = len%sheet.length(); // 나머지
                    for(int j=0; j<n1; j++)
                        play += sheet;
                    play += sheet.substring(0, n2);
                }
                // 짧으면 들은 멜로디만큼 자름
                else
                    play = sheet.substring(0, len);
                // 뮤직 클래스 생성해서 배열에 새로운 정보로 다시 저장
                musics[i] = new music(title, play);
                // 노래멜로디에 들은 멜로디가 있다면 list에 저장
                if(play.contains(m))
                    list.add(musics[i]);
            }
            // 재생된 시간이 긴 순으로 정렬
            Collections.sort(list, new Comparator<music>() {
                public int compare(music m1, music m2) {
                    return m2.play.length() - m1.play.length();
                }
            });
            // list에 값이 있으면 가장 첫번째 값이 답
            if(list.size() > 0)
                answer = list.get(0).title;
            else
                answer = "(None)";

            return answer;
        }

        // #이 들어간 코드를 바꿈
        String sheetReplace(String sheet) {
            return sheet.replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f")
                    .replaceAll("G#","g").replaceAll("A#","a");
        }

        // 음악제목과 시간
        public class music {
            String title;
            String play;
            music(String title, String play) {
                this.title = title;
                this.play = play;
            }
        }
    }
}
