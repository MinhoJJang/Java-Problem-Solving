package Else.src.BOJ_1927_S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int next = Integer.parseInt(br.readLine());
            int write = 0;
            if(next == 0){
                if(!pq.isEmpty()){
                    write = pq.remove();
                }
                bw.write(write + "\n");
            }
            else {
                pq.add(next);
            }
        }

        bw.flush();
    }
}
