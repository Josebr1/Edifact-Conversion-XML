package com.github.josebr1.utils;

public class PathOutput {

    public static String format(String value){
        return value.replace(".edi", "").replace(".txt", "");
    }

}
