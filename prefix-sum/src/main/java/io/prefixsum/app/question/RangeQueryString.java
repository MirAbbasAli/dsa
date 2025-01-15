package io.prefixsum.app.question;

/*
Given a string S of length N and an array Q[][] of queries in the form {l, r, y}.
For each query, the task is to print the number of characters y present in the range [l, r].
 */
public class RangeQueryString {
    private final int[][] prefix;
    private final String word;
    private final Integer n;

    public RangeQueryString(String word, int n){
        this.word = word;
        this.n = n;
        this.prefix = new int[26][n];
    }

    private int compareCharacter(char x, char y){
        if(Character.compare(x, y)==0) return 1;
        else return 0;
    }

    public void preprocessPrefixSum(){
        char c;
        // set the 1st character as 1
        prefix[word.charAt(0) - 'a'][0] = 1;
        // build the prefix sum
        for(char x='a';x<='z';x++){
            for(int i=1;i<n;i++){
                c = word.charAt(i);
                this.prefix[x - 'a'][i] = this.prefix[x - 'a'][i-1] + compareCharacter(x, c);
            }
        }
    }
    public void query(int x, int y, char c){
        int result = 0;
        if(x == y){
            result = prefix[c-'a'][y];
        } else{
            result = this.prefix[c - 'a'][y] - ((x>0)?this.prefix[c - 'a'][x-1]:0);
        }
        System.out.println(result);
    }

}
