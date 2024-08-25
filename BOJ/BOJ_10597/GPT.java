package BOJ_10597;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GPT {

    public static void main(String[] args) {
        // 입력을 받기 위해 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 문자열 입력 받기
        String input = scanner.nextLine();
        
        // 입력된 문자열을 기반으로 복구된 순열 출력
        System.out.println(restorePermutation(input));
        
        // Scanner 객체 닫기
        scanner.close();
    }

    // 주어진 문자열 길이로부터 최대 숫자 N을 추정하는 함수
    private static int findMaxN(int length) {
        int n = 0;
        while (length > 0) {
            n++;
            if (n < 10) {
                length -= 1;  // 1자리 숫자
            } else {
                length -= 2;  // 2자리 숫자
            }
        }
        return n;
    }

    // 순열 복구 함수
    private static String restorePermutation(String s) {
        int n = findMaxN(s.length());

        // 백트래킹 시작
        Set<Integer> used = new HashSet<>();
        StringBuilder path = new StringBuilder();
        if (backtrack(0, s, used, path, n)) {
            return path.toString().trim();
        } else {
            return "No valid permutation found!";
        }
    }

    // 백트래킹을 통해 순열 복구
    private static boolean backtrack(int index, String s, Set<Integer> used, StringBuilder path, int n) {
        if (index == s.length()) {
            return used.size() == n;
        }

        for (int length = 1; length <= 2; length++) {
            if (index + length <= s.length()) {
                int num = Integer.parseInt(s.substring(index, index + length));
                if (num >= 1 && num <= n && !used.contains(num)) {
                    used.add(num);
                    int previousLength = path.length();
                    path.append(num).append(" ");

                    if (backtrack(index + length, s, used, path, n)) {
                        return true;
                    }

                    // 백트래킹 수행
                    path.setLength(previousLength);
                    used.remove(num);
                }
            }
        }
        return false;
    }
}