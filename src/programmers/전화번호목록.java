package programmers;

import java.util.Arrays;

public class 전화번호목록 {

    public static void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for(int i = 0; i<phone_book.length-1; i++) {
            String number1 = phone_book[i];
            String number2 = phone_book[i+1];

            if(number2.startsWith(number1)) {
                return false;
            }
        }

        return true;
    }
}
