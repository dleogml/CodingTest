package programmers.level2;


import java.util.*;
// 순위 검색
/*
[조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
사람들 정보가 담긴 info[]와 조건이 담긴 query[]가 주어진다
각 조건마다 이를 만족하는 사람의 수를 구해서 answer[]에 담아서 리턴
조건의 "-" 는 해당조건을 고려하지 않겠다는 의미(무조건 통과)
----
이분탐색과 dfs를 사용하여 푸는 문제
조건의 모든 경우의 수를 map에 저장
*/
public class RankSearch {
    // 효율성에서 걸려서 실패
    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for(int i=0; i<query.length; i++) {
                for(int j=0; j<info.length; j++) {
                    if(CheckCondition(info[j], query[i]) == true) {
                        answer[i]++;
                    }
                }
            }

            return answer;
        }
        public boolean CheckCondition(String s, String t) {
            boolean flag = false;
            String [] condition = new String[5];
            String[] con = t.split(" and ");
            for(int i = 0; i<con.length; i++) {
                if(i == con.length-1) {
                    String [] tmp = con[i].split(" ");
                    condition[i] = tmp[0];
                    condition[i+1] = tmp[1];
                    continue;
                }
                condition[i] = con[i];
            }
            String[] v = s.split(" ");
            for(int i =0; i<v.length; i++) {
                if(i == v.length-1) {
                    int a = Integer.parseInt(v[i]);
                    int b = Integer.parseInt(condition[i]);
                    if(a >= b) flag = true;
                    continue;
                }
                if(!v[i].equals(condition[i]) && !condition[i].equals("-")) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }

    // 다른사람의 풀이
    class Solution2 {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Map<String,List<Integer>> map=new HashMap<>();
        int[] answer;

        // dfs
        void dfs(String str,int depth,String[] info){
            if(depth==4){
                if(map.containsKey(str)==false){
                    List<Integer> list=new ArrayList<>();
                    list.add(Integer.parseInt(info[4]));
                    map.put(str,list);
                }else{
                    map.get(str).add(Integer.parseInt(info[4]));
                }
                return;
            }

            dfs(str+"-",depth+1,info);
            dfs(str+info[depth],depth+1,info);
        }

        // dfs를 통해 info의 모든경우 저장
        void setInfo(String[] info){
            for(int i=0;i<info.length;i++){
                dfs("",0,info[i].split(" "));
            }

            Iterator<String> it= map.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                List<Integer> li=map.get(key);
                Collections.sort(li);
            }
        }

        int counting(String str,int score){
            if(map.containsKey(str)==false) return 0;

            List<Integer> list=map.get(str);
            int start=0,end=list.size()-1;

            while(start<=end){
                int mid=(start+end)/2;
                if(list.get(mid)<score){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }

            return list.size()-start;
        }

        void makeAnswer(String[] query){
            for(int i=0;i<query.length;i++){
                String str="";
                String[] arr=query[i].split(" ");

                for(int j=0;j<arr.length-1;j++){
                    if(arr[j].equals("and")) continue;
                    str+=arr[j];
                }
                answer[i]=counting(str,Integer.parseInt(arr[arr.length-1]));
            }
        }

        public int[] solution(String[] info, String[] query) {
            answer = new int[query.length];
            setInfo(info);
            makeAnswer(query);
            return answer;
        }
    }
}
