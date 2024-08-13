package BOJ_4994;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        String value;
        int remain;

        Node(String value, int remain) {
            this.value = value;
            this.remain = remain;
        }
    }

    static Queue<Node> q;
    static boolean[] r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            q = new LinkedList<>();
            r = new boolean[n];
            Arrays.fill(r, false);
            bw.append(findM(n) + "\n");
            q.clear();
        }

        bw.flush();
    }

    static String findM(int n) {

        q.add(new Node("1", 1 % n));
        r[1 % n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            String value = cur.value;
            int remain = cur.remain;

            if (remain == 0) {
                return value;
            }

            String[] add = new String[] { "0", "1" };

            for (String s : add) {
                String new_value = value + s;
                int new_remain = (remain * 10 + Integer.parseInt(s)) % n;

                if (!r[new_remain]) {
                    q.add(new Node(new_value, new_remain));
                    r[new_remain] = true;
                }
            }
        }

        return "";
    }
}
