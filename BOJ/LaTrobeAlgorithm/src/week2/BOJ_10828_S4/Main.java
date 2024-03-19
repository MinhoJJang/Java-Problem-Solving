package week2.BOJ_10828_S4;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();

            String[] order_arr = order.split(" ");

            switch (order_arr[0]) {
                case "push":
                    st.push(Integer.valueOf(order_arr[1]));
                    break;

                case "pop":
                    if (!st.isEmpty()) {
                        sb.append(st.pop()+"\n");

                    } else {
                        sb.append(-1+"\n");

                    }
                    break;

                case "size":
                   sb.append(st.size()+"\n");
                    break;

                case "empty":
                    if (!st.isEmpty()) {
                        sb.append(0+"\n");
                    } else {
                        sb.append(1+"\n");
                    }
                    break;

                case "top":

                    if (!st.isEmpty()) {
                        sb.append(st.peek()+"\n");
                    } else {
                        sb.append(-1+"\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
