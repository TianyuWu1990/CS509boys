package com.capricorn.entity;

import java.util.Random;

import junit.framework.TestCase;

public class SetLetter extends TestCase {  
    public void testRandom1() throws Exception {  
//        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
        String[] c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Qu"};  
        Random random = new Random();  
//        for( int i = 0; i < 8; i ++) {  
            System.out.println(c[random.nextInt(c.length)]);  
        
    }  
} 