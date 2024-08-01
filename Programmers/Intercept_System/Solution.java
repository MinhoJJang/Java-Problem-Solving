package Intercept_System;

/*
끝나는 시간이 빠른 순서대로 나열하고,
끝나는 시간이 같다면 시작 시간이 빠른 값을 체크

그래서 그렇게 체크한 target 개수가 결국 정답이다.
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
        int len = targets.length;
        int end_time = targets[0][1];
        answer += 1;
        for (int i = 1; i < len; i++) {
            if(end_time <= targets[i][0]){
                end_time = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}