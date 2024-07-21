package com.munsal.stringManipulation.sherlockAndTheValidString;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        String output = "NO";
        Map<String, Integer> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            String currentChar = String.valueOf(s.charAt(index));
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        Map<Integer, Integer> reversedMap = new HashMap<>();
        map.forEach((key, value) -> {
            if (reversedMap.containsKey(value)) {
                reversedMap.put(value, reversedMap.get(value) + 1);
            } else {
                reversedMap.put(value, 1);
            }
        });

        if(reversedMap.values().size() <= 2) {
            Integer numberOfRepeat = reversedMap.keySet().stream().collect(Collectors.toList()).get(0);
            Integer howManyElementsHaveTheSameCondition = reversedMap.values().stream().collect(Collectors.toList()).get(0);

            if(reversedMap.values().size() <= 1) return "YES";

            if(numberOfRepeat <= 1 && howManyElementsHaveTheSameCondition<= 1) {
                return "YES";
            }

            if(reversedMap.containsKey(numberOfRepeat+1)) {
                if(reversedMap.get(numberOfRepeat+1) <= 1) {
                    output="YES";
                } else {
                    output="NO";
                }
            }

            if(reversedMap.containsKey(numberOfRepeat-1)) {
                if(reversedMap.get(numberOfRepeat-1) <= 1) {
                    output="YES";
                } else {
                    output="NO";
                }
            }

        } else {
            output="NO";
        }
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String result = Result.isValid("aaaabbcc");

        String result = Result.isValid("aabbc");
        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
