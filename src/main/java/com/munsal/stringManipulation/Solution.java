package com.munsal.stringManipulation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    
    
    public static int makeAnagram(String a, String b) {
    // Write your code here
        Map<Character,Integer> anagramMapA = new HashMap<>();
        Map<Character,Integer> anagramMapB = new HashMap<>();
        int indexOfA = 0;
        int indexOfB = 0;

        while(indexOfA < a.length() || indexOfB < b.length()) {

            if(indexOfA < a.length()) {
                char charA = a.charAt(indexOfA++);
                if(anagramMapA.containsKey(charA)) {
                    anagramMapA.put(charA,anagramMapA.get(charA)+1);
                } else {
                    anagramMapA.put(charA,1);
                }
            }

            if(indexOfB < b.length()) {
                char charB = b.charAt(indexOfB++);
                if(anagramMapB.containsKey(charB)) {
                    anagramMapB.put(charB,anagramMapB.get(charB)+1);
                } else {
                    anagramMapB.put(charB,1);
                }
            }

        }


        Map<Character,Integer> mergedMap = new HashMap<>(anagramMapB);

        anagramMapA.forEach((character, integer) -> mergedMap.merge(character,integer,(integer1, integer2) -> Math.abs(integer1 - integer2)));

        return mergedMap.values().stream().reduce(0,Integer::sum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String a = bufferedReader.readLine();
//
//        String b = bufferedReader.readLine();
//        String a = "fcrxzwscanmligyxyvym";
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int res = Result.makeAnagram(a, b);

        System.out.println(res);
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
