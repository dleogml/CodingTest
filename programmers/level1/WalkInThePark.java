package programmers.level1;

// 공원산책
public class WalkInThePark {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];

            int [] start = new int [2];
            String [][] map = new String[park.length][park[0].length()];

            // 스타트지점 찾아서 저장
            for(int i = 0; i < park.length; i++) {
                if(park[i].contains("S")) {
                    start[0] = i;
                    start[1] = park[i].indexOf("S");
                    break;
                }
            }

            // 이중배열로 새로 저장
            for(int i = 0; i < park.length; i++) {
                map[i] = park[i].split("");
            }
            int h = map.length;
            int w = map[0].length;

            System.out.println("시작지점 : " + start[0] + " " + start[1]);
            System.out.println("높이, 넓이 : " + h + " " + w);

            // 위치이동
            for(int i = 0; i < routes.length; i++) {
                String [] info = routes[i].split(" ");
                int size = Integer.parseInt(info[1]);
                move(info[0], size, start, h, w, map);
            }

            answer[0] = start[0];
            answer[1] = start[1];

            return answer;
        }

        public void move(String direction, int size, int [] start, int height, int width, String[][] map) {
            int [] temp = {start[0], start[1]};
            try {
                if(direction.equals("N") && temp[0] - size >= 0) {
                    for(int i = temp[0] - 1; i >= temp[0] - size; i--) {
                        if(map[i][start[1]].equals("X")) {
                            System.out.println("갈수없음");
                            start[0] = temp[0];
                            break;
                        } else {
                            start[0] = start[0] - 1;
                        }
                    }
                } else if(direction.equals("S") && temp[0] + size < height) {
                    for(int i = temp[0] + 1; i <= temp[0] + size; i++) {
                        if(map[i][start[1]].equals("X")) {
                            System.out.println("갈수없음");
                            start[0] = temp[0];
                            break;
                        } else {
                            start[0] = start[0] + 1;
                        }
                    }
                } else if(direction.equals("W") && temp[1] - size >= 0) {
                    for(int i = temp[1] - 1; i >= temp[1] - size; i--) {
                        if(map[start[0]][i].equals("X")) {
                            System.out.println("갈수없음");
                            start[1] = temp[1];
                            break;
                        } else {
                            start[1] = start[1] - 1;
                        }
                    }
                } else if(direction.equals("E") && temp[1] + size < width) {
                    for(int i = temp[1] + 1; i <= temp[1] + size; i++) {
                        if(map[start[0]][i].equals("X")) {
                            System.out.println("갈수없음");
                            start[1] = temp[1];
                            break;
                        } else {
                            start[1] = start[1] + 1;
                        }
                    }
                } else {
                    System.out.println("밖으로 통과");
                }
            } catch(IndexOutOfBoundsException e) {
                System.out.println(e);
            }

        }
    }
}
