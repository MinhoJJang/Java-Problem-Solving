package week12.BOJ_16472_G4;

import java.util.*;

public class Main {

    private static int cur_type_of_alphabet = 1;
    private static int[] alphabet = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] cat_word = sc.nextLine().toCharArray();
        int start = 0;
        int end = 0;
        int len = cat_word.length;

        int max_subset_length = 1;
        int cur_subset_length = 1;

        alphabet[cat_word[start] - 'a'] += 1;

        while (start < len && end < len && start <= end) {
            if (cur_type_of_alphabet <= N) {
                max_subset_length = max_subset_length > cur_subset_length ? max_subset_length : cur_subset_length;

                end++;
                if (end == len) break;
                if (alphabet[cat_word[end] - 'a'] == 0) cur_type_of_alphabet++;
                alphabet[cat_word[end] - 'a']++;
                cur_subset_length++;
            } else if (cur_type_of_alphabet > N) {
                if (alphabet[cat_word[start] - 'a'] == 1) cur_type_of_alphabet--;
                alphabet[cat_word[start] - 'a']--;
                cur_subset_length--;
                start++;
            }
        }

        System.out.println(max_subset_length);
    }
}
