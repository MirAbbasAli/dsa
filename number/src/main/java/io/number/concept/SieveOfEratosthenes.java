package io.number.concept;

import io.number.problem.driver.FastReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class SieveOfEratosthenes {
    private static final Boolean[] isPrime = new Boolean[100000];
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void primeSieve(){
        Arrays.fill(isPrime, true); // set all the number as prime number
        isPrime[0] = isPrime[1] = false; // 0 & 1 are not prime number

        for(int prime = 2; prime * prime < isPrime.length; prime++){
            if(isPrime[prime]) // mark only for prime number
                for(int mark = prime * prime; mark < isPrime.length; mark += prime) // start from p^2 as (2,p^2) is already covered in previous iteration
                    isPrime[mark] = false;
        }
    }

    public static void primeSieveWithOdd(){ // slightly optimized solution
        Arrays.fill(isPrime, false);
        isPrime[2] = true;
        // it is considered all even number are not prime by default, and we check only for odd
        for(int i = 3; i < isPrime.length; i+=2){ // mark all odd as prime
            isPrime[i] = true;
        }

        for(int prime = 3; prime * prime < isPrime.length; prime++){
            if(isPrime[prime])
                for(int mark = prime * prime; mark < isPrime.length; mark += prime)
                    isPrime[mark] = false;
        }
    }

    public static void main(String[] args){
        primeSieve();
        int n = in.nextInt();
        out.println(isPrime[n]);

        out.flush();
        out.close();
    }
}
