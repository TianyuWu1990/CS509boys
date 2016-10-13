package com.capricorn.entity;

import java.util.Random;

public class Cell {
public String letter;

public String getLetter() {
	return letter;
}

public void setLetter() {
	String[] c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","Qu"};  
    Random random = new Random();  
//    for( int i = 0; i < 8; i ++) {  
//        System.out.println(c[random.nextInt(c.length)]); 
    this.letter = c[random.nextInt(c.length)];
    
	}  

}


