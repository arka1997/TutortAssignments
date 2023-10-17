package com.TutortAssignment.TutortAssignmentCodes.Stack;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SimplifyPath {
// GOLDEN RULES:
// The path starts with a single slash '/'.
// Any two directories are separated by a single slash '/'.
// The path does not end with a trailing '/'.
// The path only contains the directories on the path from the root directory
//o  to the target file or directory (i.e., no period '.' or double period '..')
public static String simplifyPath(String path) {
    // using Regex by passing through certain filters
    Stack<String> s = new Stack<String>();
    String[] arr = path.split("/");

    for(int i = 0; i < arr.length;i++){
        if(!s.isEmpty() && arr[i].equals("..")){//means go back to previous folders
            s.pop();
        }else if(
                !arr[i].equals(".") &&
                        !arr[i].equals("..") &&
                        !arr[i].equals("/") &&
                        !arr[i].equals("_") &&
                        !arr[i].equals("")
        ) {
            s.push(arr[i]);
        }
        System.out.println(s);
    }
    if(s.isEmpty()){
        return "/";
    }
    System.out.println(s.stream().map(e -> "/" + e).collect(Collectors.joining()));
    return null;
}

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}