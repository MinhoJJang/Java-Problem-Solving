package BOJ_1360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Answer {

    static final String DISABLE = "disable";
    static final String ABLE = "able";


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] input = new String[N][4];
        // 0: 명령 1: 단어 혹은 되돌리는 시간 2: 실행시간 3: 실행가능성(기본값 ABLE)
        Stack<String> answer = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = st.nextToken();
            input[i][1] = st.nextToken();
            input[i][2] = st.nextToken();
            input[i][3] = ABLE;
        }

        for (int i = N - 1; i >= 0; i--) {

            if(input[i][3] != ABLE) continue;

            switch (input[i][0]) {
                case "type": 
                    answer.add(input[i][1]);
                    break;
            
                case "undo":
                    int end = Integer.parseInt(input[i][2]);
                    int start = end - Integer.parseInt(input[i][1]);
                    for (int j = i; j >= 0; j--) {
                        if(Integer.parseInt(input[j][2]) < start) break;
                        input[j][3] = input[j][3].equals(ABLE) ? DISABLE : ABLE; 
                    }
                    break;
            }
        }

        while(!answer.isEmpty()) {
            sb.append(answer.pop());
        }

        System.out.println(sb);
        
    }

}
