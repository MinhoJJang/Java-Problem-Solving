package BOJ_23323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()); // init health
            long m = Long.parseLong(st.nextToken()); 
            int cnt = 1;

            while(n != 1){
                n /= 2;
                cnt++;
            }
            
            bw.write(cnt+m+"\n");
        }
        bw.flush();
    }
}
