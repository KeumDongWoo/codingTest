package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0;
        int time = 0;

        Queue<Integer> inBridgeTruck = new LinkedList<>();

        for(int truck : truck_weights) {
            while(true) {
                if(inBridgeTruck.isEmpty()) { // 다리에 차량이 없는경우
                    inBridgeTruck.offer(truck); //다리에 차량 추가
                    bridgeWeight += truck;
                    time ++;
                    break;
                } else if(inBridgeTruck.size() == bridge_length){ // 다리에 차량이 들어갈자리가 없는경우
                    bridgeWeight -= inBridgeTruck.poll();
                } else {
                    if(bridgeWeight + truck <= weight) { // 다리에 자리도 있고 트럭을 실을수있는 무게가 있는경우
                        inBridgeTruck.offer(truck);
                        bridgeWeight += truck;
                        time ++;
                        break;
                    } else { // 무게는 초과지만 자리가있으면 0으로 채워넣음
                        inBridgeTruck.offer(0);
                        time ++;
                    }
                }
            }
        }

        answer += time + bridge_length; // 걸린시간 + 마지막차량 시간

        return answer;
    }
}
