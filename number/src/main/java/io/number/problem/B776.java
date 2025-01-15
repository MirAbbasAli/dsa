package io.number.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B776 {

    private static final Integer[] jewelryColor = new Integer[100002];

    public static void setJewelryColor(){
        Arrays.fill(jewelryColor, 1);
        int size = jewelryColor.length;
        int secondColor = 2;
        for(int i=2; i*i < size; i++){
            if (jewelryColor[i] != secondColor) // don't run for composite
                for(int j=i*i; j < size; j+=i){
                    if (jewelryColor[j] == 1) {
                        jewelryColor[j] = secondColor;
                    }
                }
        }
    }
    public static void main(String[] args){
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        setJewelryColor();
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int k = n <= 2 ? 1 : 2;
            out.println(k);
            for(int i=2; i<=n+1; i++){
                out.print(jewelryColor[i]+" ");
            }
            out.println();
        }
        out.flush();
        out.close();
    }
    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public String nextLine(){
            String str = "";
            try {
                if (st!=null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

    }
}
