package programmers;

import java.util.HashMap;

public class 위장 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();

        for(String[] wear : clothes) {
            String key = wear[1];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            } else {
                map.put(key,1);
            }
        }

        for(String mapKey : map.keySet()){
            int value = map.get(mapKey);
            answer *= value + 1; // ex) 상의 2개 하의 2개 -> 상의 0,1,2 * 하의 0,1,2
        }

        return answer-1; // 하나도 안입은 케이스 제외
    }
}
