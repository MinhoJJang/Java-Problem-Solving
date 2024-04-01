package week4.BOJ_16936_G5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<BigInteger> answer = new ArrayList<>();

    static void findProgression(BigInteger currentNumber, int N, int depth, ArrayList<BigInteger> numbers) {

        answer.add(currentNumber);
        numbers.remove(currentNumber);

        if (answer.size() == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.exit(0);
        } else if (depth < N) {
            BigInteger two = BigInteger.valueOf(2);
            BigInteger three = BigInteger.valueOf(3);
            BigInteger zero = BigInteger.ZERO;

            if (numbers.contains(currentNumber.multiply(two))) {
                findProgression(currentNumber.multiply(two), N, depth + 1, numbers);
            }
            if (numbers.contains(currentNumber.divide(three)) && currentNumber.mod(three).equals(zero)) {
                findProgression(currentNumber.divide(three), N, depth + 1, numbers);
            }
            answer.remove(currentNumber);
            numbers.add(currentNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<BigInteger> numbers = new ArrayList<>();
        BigInteger[] static_numbers = new BigInteger[N];

        for (int i = 0; i < N; i++) {
            BigInteger num = sc.nextBigInteger();
            numbers.add(num);
            static_numbers[i] = num;
        }

        for (int i = 0; i < N; i++) {
            findProgression(static_numbers[i], N, 0, numbers);
        }
    }
}
