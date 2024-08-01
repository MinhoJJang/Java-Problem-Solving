package BOJ_3273_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n; // 수열의 크기
        n = sc.nextInt();

        int[] arr = new int[n]; // 수열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x; // 만들어야 하는 숫자
        x = sc.nextInt();

        // 1. arr 배열 정렬
        Arrays.sort(arr);

        // 2. arr 배열에서 처음과 끝 idx를 지정
        int first_idx = 0;
        int end_idx = n-1;
        int answer = 0;

        // 3. 처음 idx를 1씩 증가시키면서 값 저장
        while(first_idx < end_idx){

            // arr[end_idx}와 arr[first_idx]를 더한다
            // 만약 그 값이 x 보다 크다면 end_idx를 1 감소시키고 continue;
            // 만약 그 값이 x 보다 작다면 first_idx를 1 증가시키고 continue;
            // 같으면 answer++ 해주고 first_idx, end_idx를 각각 증가/감소시킨다.
            int checkSum = arr[first_idx] + arr[end_idx];
            if (checkSum > x) {
                end_idx--;
            }
            else if(checkSum < x){
                first_idx++;
            }
            else{
                answer++;
                first_idx++;
                end_idx--;
            }
        }

        System.out.println(answer);
    }
}
// 맞았습니다!