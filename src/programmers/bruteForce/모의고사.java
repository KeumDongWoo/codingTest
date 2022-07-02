package programmers.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = {0,0,0};

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) {
                scores[0] += 1;
            }
            if(answers[i] == two[i%8]) {
                scores[1] += 1;
            }
            if (answers[i] == three[i%10]) {
                scores[2] += 1;
            }
        }

        int[] arr = new int[scores.length];
        for(int i = 0; i < scores.length; i++){
            arr[i] = scores[i];
        }

        Arrays.sort(scores);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i < scores.length; i++) {
            if(arr[i] == scores[2]) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
