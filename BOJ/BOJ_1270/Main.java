package BOJ_1270;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            HashMap<Long, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int total = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                long p = Long.parseLong(st.nextToken());
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }

            String answer = "SYJKGW";

            for (Map.Entry<Long, Integer> entry : map.entrySet()) {

                long type = entry.getKey();
                int num = entry.getValue();

                if (num > total / 2) {
                    answer = String.valueOf(type);
                    break;
                }
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
