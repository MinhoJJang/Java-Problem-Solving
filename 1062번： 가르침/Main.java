/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1062                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1062                           #+#        #+#      #+#    */
/*   Solved: 2024/09/03 21:02:51 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    static final int LEARNED = 1;
    static final char[] essential = new char[] {'a', 'n', 't', 'i', 'c'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] words = new String[N];
        char[] learned = new char[26];
        
        for(char c : essential){
            learned[c - 'a'] = LEARNED;
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = input.substring(4, input.length() - 4);
        }



    }
}