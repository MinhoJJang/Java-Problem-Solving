//package BOJ_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[X];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int visitors = 0;
        int max = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            visitors += arr[i];
        }

        max = visitors;

        for (int i = N; i < X; i++) {
            visitors = visitors + arr[i] - arr[i-N];
            if(max == visitors){
                cnt += 1;
            }
            else if(max < visitors){
                cnt = 1;
                max = visitors;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
