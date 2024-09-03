//package BOJ_4821;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int PRINT = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            
            int total = Integer.parseInt(br.readLine());
            if(total == 0) break;

            int[] print = new int[total + 1];
            String input = br.readLine();
            String[] range = input.split(",");
            int cnt = 0;


            for(String s : range){
                String[] r = s.split("-");
                int len = r.length;
                int start = Integer.parseInt(r[0]);

                if(start > total) continue;

                if(len == 1){
                    print[start] = PRINT;
                }
                else {
                    int end = Math.min(Integer.parseInt(r[1]), total);
                    if(start > end) continue;
                    for (int i = start; i <= end; i++) {
                        print[i] = PRINT;
                    }
                }
            }

            for (int i = 0; i <= total; i++) {
                if(print[i] == PRINT) cnt++;
            }

            bw.write(cnt+"\n");
        }

        bw.flush();
    }
}
