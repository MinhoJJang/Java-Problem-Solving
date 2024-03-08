package BOJ_2309_B1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> height = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            height.add(n);
        }

        int target = height.stream().mapToInt(Integer::intValue).sum() - 100;
        Collections.sort(height);
        boolean flag = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (height.get(i) + height.get(j) == target) {
                    height.remove(j);
                    height.remove(i);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        for (int num : height) {
            System.out.println(num);
        }
    }
}
