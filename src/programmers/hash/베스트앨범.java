package programmers.hash;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution2 solution2 = new Solution2();

        System.out.println(solution2.solution(genres,plays));
    }
}

class Solution2{

    static class Music {
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> sumAlbam = new HashMap<>();
        // 엘범별 노래재생횟수 SUM
        for(int i=0; i<genres.length; i++) {
            String key = genres[i];

            if(sumAlbam.containsKey(key)) {
                sumAlbam.put(key,sumAlbam.get(key) + plays[i]);
            } else {
                sumAlbam.put(key,plays[i]);
            }
        }

        // 노래 장르 선정
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(sumAlbam.size() != 0) {
            int max = -1;
            String maxKey = null;

            for(String key : sumAlbam.keySet()) {
                int value = sumAlbam.get(key);
                if(max < value) {
                    max = value;
                    maxKey = key;
                }
            }
            genres_ordered.add(maxKey);
            sumAlbam.remove(maxKey);
        }

        // 베스트 엘범 완성
        ArrayList<Music> resultListMusic = new ArrayList<>();
        for(String gern : genres_ordered) {

            // 장르 + 재생수
            ArrayList<Music> musicList = new ArrayList<>();
            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(gern)) {
                    musicList.add(new Music(gern,plays[i],i));
                }
            }
            // 내림차순 정렬
            Collections.sort(musicList, ((o1, o2) -> o2.play - o1.play));
            // 한개는 무조건
            resultListMusic.add(musicList.get(0));
            // 두곡이상인경우
            if(musicList.size() > 1) {
                resultListMusic.add(musicList.get(1));
            }
        }

        // 결과 출력
        int[] answer = new int[resultListMusic.size()];
        for(int i=0; i<resultListMusic.size(); i++){
            answer[i] = resultListMusic.get(i).idx;
        }

        return answer;
    }
}