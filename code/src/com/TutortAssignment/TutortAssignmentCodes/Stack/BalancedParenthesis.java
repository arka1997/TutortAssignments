package com.TutortAssignment.TutortAssignmentCodes.Stack;

import java.io.*;
import java.util.*;
import java.util.stream.*;




class BalencedParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static String isBalanced(String str) {
        if(str.length()==0){
            return "YES";
        }
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'||str.charAt(i)=='[' ||str.charAt(i)=='('){
                s.push(str.charAt(i));
            }
            else if(s.isEmpty()){
                return "NO";
            }else if(str.charAt(i)=='}'&& s.peek()=='{'||str.charAt(i)==']'&&s.peek()=='['||str.charAt(i)==')'&&s.peek()=='('){
                s.pop();
            }else{
                return "NO";
            }
        }
        if(!s.isEmpty()){
            return "NO";
        }
        return "YES";
    }
}
