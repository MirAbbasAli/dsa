package io.prefixsum.app;

import io.prefixsum.app.driver.FastReader;
import io.prefixsum.app.question.RangeQueryString;

public class PrefixSumApplication {
    private static final FastReader s = new FastReader();
    public static void rangeQueryString(){
        String word = s.nextLine();
        int n = word.length();
        int numOfQueries = s.nextInt();

        RangeQueryString r = new RangeQueryString(word, n);
        r.preprocessPrefixSum();

        while(numOfQueries-->0){
            String input = s.nextLine();
            String[] queryParam = input.split(" ");
            int x = Integer.parseInt(queryParam[0]);
            int y = Integer.parseInt(queryParam[1]);
            char c = queryParam[2].charAt(0);
            r.query(x, y, c);
        }
    }
    public static void main(String[] args){
       rangeQueryString();
    }
}
