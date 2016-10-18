package com.topcheer.ybt.basedata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;



public class a {
    public static void main(String[] args) {
        System.out.println(f(5)); 

    }

     public static int f(int n) {  
            if (1 == n)   
                return 1;  
            else   
                return n * f(n-1);  
     }
}
