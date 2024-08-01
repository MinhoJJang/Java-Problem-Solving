package week3.BOJ_1302_S4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            String bookName = bf.readLine();
            if(map.containsKey(bookName)){
                int cnt = map.get(bookName) + 1;
                map.remove(bookName);
                map.put(bookName, cnt);
                continue;
            }
            map.put(bookName, 0);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            // 먼저 cnt 내림차순으로 정렬
            int comparison = o2.getValue().compareTo(o1.getValue());
            // cnt가 같으면 책 이름 사전순으로 정렬
            if (comparison == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return comparison;
        });

        System.out.println(list.get(0).getKey());
    }
}
