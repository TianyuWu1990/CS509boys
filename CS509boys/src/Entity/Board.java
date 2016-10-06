package Entity;

public class Board {
public Cell letterArray[][] = new Cell[4][4];

public void setleeterArray(){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			letterArray[i][j] = new Cell();
			letterArray[i][j].setLetter();
		}
	}
}
public static void main(String[] args){
	Board board = new Board();
	board.setleeterArray();
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			System.out.print(board.letterArray[i][j].letter
					+" ");
			
			
		}
		System.out.println();
	}
	
//		System.out.print(board.letterArray[2][3].letter);
//	}

}
}
