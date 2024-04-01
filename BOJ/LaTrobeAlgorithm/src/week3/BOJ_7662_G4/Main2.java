package week3.BOJ_7662_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> tm = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                if (input[0].equals("I")) {
                    long number = Long.parseLong(input[1]);
                    tm.put(number, tm.getOrDefault(number, 0) + 1);
                } else if (input[0].equals("D")) {
                    if (!tm.isEmpty()) {
                        if (input[1].equals("-1")) {
                            tm.pollFirstEntry();
                        } else {
                            tm.pollLastEntry();
                        }
                    }
                }
            }

            if(tm.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(tm.lastKey()+ " " + tm.firstKey());
            }
        }
    }
}
