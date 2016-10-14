package com.capricorn.entity;

import java.util.Random;

public class Cell {
public String letter;
public String points;

public String getLetter() {
	return letter;
}
public String getPoints() {
	return points;
}

public void setLetter() {
	String[] c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","Qu"};  
    String[] p = {"2","4","3","3","1","4","4","2","2","7","5","3","3","2","2","4","2","2","1","3","5","3","7","4","8","11"};
	Random random = new Random();  
//    for( int i = 0; i < 8; i ++) {  
//        System.out.println(c[random.nextInt(c.length)]); 
	int rand = random.nextInt(c.length);
    this.letter = c[rand];
    this.points = p[rand];
    
	}  

}


