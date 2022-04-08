package com.kiramiki.jvm3;

import java.time.LocalDate;

public class forEachDemo {

    public static void main(String[] args) {
        String s = "10401005";
        String professCode = "0";
        switch (s){
            case "10401001": professCode = "1";break;
            case "10401002": professCode = "2";break;
            case "10401005": professCode = "3";break;
            case "10401010": professCode = "4";break;
            case "10401007": professCode = "5";break;
            case "10401012": professCode = "6";break;
        }
        System.out.println(professCode);
    }
}
