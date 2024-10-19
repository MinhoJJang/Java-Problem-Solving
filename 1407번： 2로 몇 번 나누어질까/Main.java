/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1407                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: ahchjang <boj.kr/u/ahchjang>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1407                           #+#        #+#      #+#    */
/*   Solved: 2024/10/19 16:57:07 by ahchjang      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger A = BigInteger.valueOf(Long.parseLong(input[0]) - 1);
        BigInteger B = BigInteger.valueOf(Long.parseLong(input[1]));
        int e = 1;

        BigInteger answer = B.subtract(A);

        while (true) {
            BigInteger div = BigInteger.valueOf((long)Math.pow(2, e++));
            BigInteger a = A.divide(div);
            BigInteger b = B.divide(div);
            if(b.equals(BigInteger.ZERO)) break;
            answer = answer.add((b.subtract(a)).multiply(div.divide(BigInteger.TWO)));
        }

        System.out.println(answer.toString());
    }
}