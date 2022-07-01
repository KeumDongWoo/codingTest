package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int days[] = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int remainder = 100 - progress;
            days[i] = ((remainder % speed) != 0) ? remainder/speed + 1 : remainder/speed;
        }

        int maxRecent = days[0];
        int cnt = 1;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<days.length; i++){
            if(maxRecent < days[i]) {
                list.add(cnt);
                cnt = 1;
                maxRecent = days[i];
            } else {
                cnt ++;
            }
        }

        list.add(cnt);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
