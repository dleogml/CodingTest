package programmers.level2;

import java.util.LinkedList;

// 캐시
// 캐시크기와 도시이름 배열이 주어진다
// 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다
// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
// cache hit일 경우 실행시간은 1, cache miss일 경우 실행시간은 5
public class Cache {
    // linkedList를 사용
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            LinkedList<String> cache = new LinkedList<>();

            for(int i=0; i<cities.length; i++) {
                // 캐시 자체가 없다면 올 miss이므로
                if(cacheSize == 0) {
                    answer = cities.length * 5;
                    break;
                }
                // 비교할 값 설정, 소문자로 통일
                String city = cities[i].toLowerCase();

                // 1)캐시에 이미 값이 있을 경우
                // 해당 값을 캐시에서 지우고 맨뒤에 넣어줌으로써 가장 최신값을 맨뒤로 보냄
                if(cache.contains(city)) {
                    answer+=1;
                    cache.remove(city);
                    cache.add(city);
                }
                // 2)캐시에 값이 없을 경우
                else {
                    // 2-1)해당 값이 없지만 캐시가 가득찼을 경우
                    // 맨 앞에 값은 제일 오래된 값이므로 삭제
                    // 새로운 값을 맨뒤에 추가
                    if(cache.size() == cacheSize) {
                        answer+=5;
                        cache.poll();
                        cache.add(city);
                    }
                    // 2-2)해당 값이 없고 캐시가 비어있을 경우
                    // 새로운 값을 맨뒤에 추가
                    else {
                        answer+=5;
                        cache.add(city);
                    }
                }
            }

            return answer;
        }
    }

    // 나의 풀이
    // 일부 테스트케이스에서는 실패
    // 캐쉬 구조나 LRU알고리즘을 생각했을 때 큐의 형태로 짰어야 했다
    class Solution2 {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            String [] cache = new String[cacheSize];
            for(int i=0; i<cities.length; i++) {
                cities[i] = cities[i].toLowerCase();
            }

            for(int i=0; i<cities.length; i++) {
                if(cacheSize == 0) {
                    answer = cities.length * 5;
                    break;
                }

                if(i >= cacheSize && check(cacheSize, cities[i], cache) == 0) {
                    cache[i%cacheSize] = cities[i];
                    answer = answer + 5;
                }
                else if(i < cacheSize) {
                    cache[i%cacheSize] = cities[i];
                    answer = answer + 5;
                }
                else {
                    answer = answer + 1;
                }
            }

            return answer;
        }
        public int check(int c, String s, String[] str) {
            for(int i=0; i<c; i++){
                if(str[i].equals(s)) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
