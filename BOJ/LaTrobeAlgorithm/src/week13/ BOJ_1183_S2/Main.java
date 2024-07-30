

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[] diff = new int[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            diff[i] = A - B;
        }
        
        Arrays.sort(diff);
        if(N % 2 != 0){
            answer = 1;
        } else {
            int a = diff[N / 2];
            int b = diff[N / 2 - 1];
            answer = a - b + 1;
        }

        System.out.println(answer);

    }
}