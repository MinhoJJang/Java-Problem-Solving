package week2.BOJ_1874_S2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static final String push = "+\n";
    static final String pop = "-\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];
        int idx = 0;
        int value = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 2 * n; i++) {

            if (st.contains(arr[idx])) {
                if (st.peek().equals(arr[idx++])) {
                    st.pop();
                    sb.append(pop);
                    continue;
                } else {
                    System.out.println("NO");
                    return;
                }
            }

            st.push(value++);
            sb.append(push);
        }

        System.out.println(sb);
    }
}
