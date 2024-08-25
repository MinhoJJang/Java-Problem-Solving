package BOJ_1268;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> friendsInSameClass;
        int[] friendsCount = new int[N + 1];

        int[][] info = new int[N + 1][6];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int student = 1; student <= N; student++) {
            friendsInSameClass = new HashSet<>();
            for (int gradeLevel = 1; gradeLevel <= 5; gradeLevel++) {
                int curStudentClass = info[student][gradeLevel];
                for (int friends = 1; friends <= N; friends++) {
                    if (student == friends)
                        continue;
                    if (info[friends][gradeLevel] == curStudentClass)
                        friendsInSameClass.add(friends);
                }
            }
            friendsCount[student] = friendsInSameClass.size();
        }

        int max = 0;
        int answer = 1;
        for (int student = 1; student <= N; student++) {
            if (friendsCount[student] > max) {
                max = friendsCount[student];
                answer = student;
            }
        }

        System.out.println(answer);
    }
}
