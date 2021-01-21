package programmers.level3;

// 추석 트래픽
/*
- solution 함수에 전달되는 lines 배열은 N(1 ≦ N ≦ 2,000)개의 로그 문자열로 되어 있으며,
  각 로그 문자열마다 요청에 대한 응답완료시간 S와 처리시간 T가 공백으로 구분되어 있다.
- 응답완료시간 S는 작년 추석인 2016년 9월 15일만 포함하여 고정 길이 2016-09-15 hh:mm:ss.sss 형식으로 되어 있다.
- 처리시간 T는 0.1s, 0.312s, 2s 와 같이 최대 소수점 셋째 자리까지 기록하며 뒤에는 초 단위를 의미하는 s로 끝난다.
- 예를 들어, 로그 문자열 "2016-09-15 03:10:33.020 0.011s"은 2016년 9월 15일 오전 3시 10분 **33.010초**부터
  2016년 9월 15일 오전 3시 10분 **33.020초**까지 **0.011초** 동안 처리된 요청을 의미한다. (처리시간은 시작시간과 끝시간을 포함)
- 서버에는 타임아웃이 3초로 적용되어 있기 때문에 처리시간은 0.001 ≦ T ≦ 3.000이다.
- lines 배열은 응답완료시간 S를 기준으로 오름차순 정렬되어 있다.
 */
// 로그 데이터 lines 배열에 초당 최대 처리량을 리턴
public class ChuseokTraffic {
    class Solution {
        public int solution(String[] lines) {
            //시작시간
            double[] start = new double[lines.length];
            //끝난시간
            double[] end = new double[lines.length];
            for(int i = 0; i < lines.length; i++) {
                //초단위로 나누기위한 split
                String responTime = lines[i].split(" ")[1];
                //처리 시간
                String handleTime = lines[i].split(" ")[2];

                double endTime = 0.0;
                double startTime = 0.0;
                //시, 분을 초단위로 변환
                endTime += 3600.0 * Double.parseDouble(responTime.split(":")[0]);
                endTime += 60.0  * Double.parseDouble(responTime.split(":")[1]);
                endTime += Double.parseDouble(responTime.split(":")[2]);

                //s를 빼고 응답시간을 빼주면 시작시간
                startTime = Math.round((endTime - Double.parseDouble(handleTime.replace("s", ""))+0.001)*1000)/1000.0;

                // 끝난시간과 시작시간 배열에 넣어줌
                end[i] = endTime;
                start[i] = startTime;

            }
            int answer = 0;
            for(int i = 0; i < lines.length; i++) {
                double startTemp = start[i];
                double endTemp = end[i];
                //로그 start 지점에서 1초안에 있는 로그 수
                int startCount = 0;
                //로그 end 시점에서 1초안에 있는 로그 수
                int endCount = 0;
                for(int j = 0; j < lines.length; j++) {
                    //로그 시작시점 기준으로 1초뒤 시간
                    double startsSection = Math.round((startTemp+0.999)*1000)/1000.0;
                    //로그 끝 시점 기준으로 1초뒤 시간
                    double endSection = Math.round((endTemp+0.999)*1000)/1000.0;
                    //임의 로그의 시작 부분과 끝부분이 다른 로그의 끝 부분 보다 작고 시작 부분보다 크다면,
                    if(startTemp <= end[j] && start[j] <= startsSection) {
                        startCount++;
                    }
                    //로그의 end부분에서도 똑같이 실행
                    if(endTemp <= end[j] && start[j] <= endSection) {
                        endCount++;
                    }
                }
                //최대 처리량만 구하기.
                if(answer < Math.max(startCount, endCount)) {
                    answer = Math.max(startCount, endCount);
                }
            }

            return answer;
        }
    }
}
