package week3.BOJ_18111_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main {

    static final int add = 1;
    static final int remove = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");
        int N = Integer.parseInt(value[0]);
        int M = Integer.parseInt(value[1]);
        int B = Integer.parseInt(value[2]);

        // index = 드는 시간 value = 땅의 높이
        TreeMap<Integer, Integer> map = new TreeMap<>();

        ArrayList<Integer> land_height_arr = new ArrayList<>(N * M);
        for (int i = 0; i < N; i++) {
            String[] hg = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                land_height_arr.add(Integer.valueOf(hg[j]));
            }
        }
        int bottom = Collections.min(land_height_arr);
        int top = Collections.max(land_height_arr);

        for (int target_height = bottom; target_height <= top; target_height++) {
            int target_height_time = 0;
            int target_block_needed = 0;
            int inventory_block = B;

            for (int i = 0; i < N * M; i++) {
                int land_height = land_height_arr.get(i);
                if (land_height > target_height) {
                    target_height_time += ((land_height - target_height) * remove);
                    inventory_block += land_height - target_height;
                } else if (land_height < target_height) {
                    target_block_needed += target_height - land_height;
                    target_height_time += ((target_height - land_height) * add);
                }
            }

            if (target_block_needed <= inventory_block) {
                map.put(target_height_time, target_height);
            }
        }

        System.out.println(map.firstKey() + " " + map.get(map.firstKey()));
    }
}
