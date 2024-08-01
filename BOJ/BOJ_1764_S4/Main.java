package week3.BOJ_1764_S4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = bf.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(bf.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = bf.readLine();
            if(set.contains(name)){
                list.add(name);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list) {
            bw.write(name + "\n");
        }

        bw.flush();
    }
}
