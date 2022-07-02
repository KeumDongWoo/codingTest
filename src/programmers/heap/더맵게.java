package programmers.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(solution(scoville,k));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int scov : scoville) heap.add(scov);

        while(heap.peek() < K) {
            if(heap.size() < 2) return -1;
            int a = heap.poll();
            int b = heap.poll();

            int sum = a + (b*2);
            heap.offer(sum);
            answer ++;
        }

        return answer;
    }
}
