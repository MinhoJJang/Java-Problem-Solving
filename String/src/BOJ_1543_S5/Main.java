package BOJ_1543_S5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        char[] doc_to_char = doc.toCharArray();
        char[] word_to_char = word.toCharArray();

        int doc_len = doc.length();
        int word_len = word.length();
        int word_count = 0;

        for(int i=0; i<= doc_len - word_len;  ){
            if(doc_to_char[i] == word_to_char[0]){
                int j;
                for(j=1; j<word_len; j++){
                    if(doc_to_char[i+j] != word_to_char[j]){
                        break;
                    }
                }

                if(j == word_len){
                    word_count++;
                    i+=word_len;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }

        System.out.println(word_count);
    }
}
