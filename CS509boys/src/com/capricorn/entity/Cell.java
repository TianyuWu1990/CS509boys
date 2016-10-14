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
    int k=0;
    int m=0;
	int[] pro={810,149,278,425,1270,223,202,609,697,15,77,403,241,675,751,193,599,633,906,276,98,236,15,197,7,10};
    for(int i=0;i<=25;i++){
    	m+=pro[i];
    	}
    int[] w= new int[m];
    for(int i=0; i<=25;i++){
    	for(int j=1; j<=pro[i];j++){
    		w[k]=i;
    		k++;
    	}
    };
    
	String[] p = {"2","4","3","3","1","4","4","2","2","7","5","3","3","2","2","4","2","2","1","3","5","3","7","4","8","11"};
	Random random = new Random();  
//    for( int i = 0; i < 8; i ++) {  
//        System.out.println(c[random.nextInt(c.length)]); 
	int rand = random.nextInt(w.length);
	int q = w[rand];
    this.letter = c[q];
    this.points = p[q];
    
	}  

}


