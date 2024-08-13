//package BOJ_24468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int Left = -1;
    static final int Right = 1;
    static final int none = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int[][] box = new int[L+1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            box[loc][0] = 1;
            box[loc][1] = st.nextToken().equals("R") ? Right : Left;
        }

        while(T-- >= 0){
            for (int loc = 0; loc <= L; loc++) {
                if(box[loc][0] == 0) continue;
                if(box[loc][0] == 1){
                    int dir = box[loc][1];
                    if(loc == 0) dir = Right;
                    else if(loc == L) dir = Left;
                    box[loc + dir][0]++;
                    box[loc + dir][1] = dir;
                }
                else {
                    cnt++;
                    box[loc + Left][0] += 1;
                    box[loc + Left][1] = Left;
                    box[loc + Right][0] += 1;
                    box[loc + Right][1] = Right;
                }
                box[loc][0] = 0;
                box[loc][1] = none;
                loc++;
            }
        }

        System.out.println(cnt);
    }
}   
