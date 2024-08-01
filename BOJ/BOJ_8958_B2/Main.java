package BOJ_8958_B2;

import java.util.Scanner;

/**
 * 풀이생각
 * <p>
 * 연속된 O는 연속한 개수 만큼 추가 점수를 얻는다
 * 그럼 그냥 점수를 배열에다가 저장하고
 * 이전 값에 +1 해주면 되겠네
 * <p>
 * 12분 걸림
 */
public class Main {

    static int calculate_score(String quiz) {
        int quiz_len = quiz.length();
        int[] quiz_score = new int[quiz_len];
        char[] quiz_char = quiz.toCharArray();
        int sum = 0;

        for (int i = 0; i < quiz_len; i++) {
            if (quiz_char[i] == 'O') {
                if (i > 0) {
                    quiz_score[i] = quiz_score[i - 1] + 1;
                } else {
                    quiz_score[i] = 1;
                }
            } else if (quiz_char[i] == 'X') {
                quiz_char[i] = 0;
            }

            sum += quiz_score[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] quiz_set = new String[N];
        int[] quiz_set_score = new int[N];

        for (int i = 0; i < N; i++) {
            quiz_set[i] = sc.nextLine();
            quiz_set_score[i] = calculate_score(quiz_set[i]);
            System.out.println(quiz_set_score[i]);
        }

    }
}
