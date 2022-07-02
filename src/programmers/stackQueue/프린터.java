package programmers.stackQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위 별로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities) {
            pq.add(priority);
        }

        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                // 기존 값과 우선순위 값이 동일할시 우선순위 큐에서 poll and answer + 1
                if(priorities[i] == pq.peek()) {
                    answer ++;
                    pq.poll();
                    // 찾으려는 값과 위치가 동일시 return
                    if(i == location) return answer;
                }
            }
        }

        return -1;
    }
}
