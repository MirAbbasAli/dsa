package io.number.problem;

import io.number.problem.driver.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class PrimeQueries {
    private static final Integer[] primes = new Integer[1000001];
    private static final Integer[] primePrefixes = new Integer[1000001];

    public static void primeSieve(){
        Arrays.fill(primes, 1); // set all the number as prime number
        primes[0] = primes[1] = 0; // 0 & 1 are not prime number

        for(int prime = 2; prime * prime < primes.length; prime++){
            if(primes[prime] == 1) // mark only for prime number
                for(int mark = prime * prime; mark < primes.length; mark += prime) // start from p^2 as (2,p^2) is already covered in previous iteration
                    primes[mark] = 0;
        }
    }

    public static void setPrimePrefixes(){
        primePrefixes[0] = primePrefixes[1] = primes[0];
        primePrefixes[2] = primes[2];
        for(int r=3; r<primePrefixes.length; r++)
            primePrefixes[r] = primes[r] + primePrefixes[r-1];
    }

    public static void main(String[] args){
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        primeSieve();
        setPrimePrefixes();

        int q = in.nextInt();
        while(q-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            out.println(primePrefixes[b] - primePrefixes[a-1]);// [a,b] primes
        }

        out.flush();
        out.close();
    }
}
