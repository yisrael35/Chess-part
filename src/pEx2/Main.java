package pEx2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

//		Position p=new Position(2, 3);
//		Bishop b1 =new Bishop(p);
//		System.out.println(b1);
//		Knight k1=new Knight(p);
//		System.out.println(k1);
//		ChessBoard c1=new ChessBoard();
//		c1.addPiece( b1);
//		System.out.println(Arrays.deepToString(k1.moves(p)));
		ChessBoard board = new ChessBoard();
		board.addPiece(new Knight(new Position(5, 2)));
		board.addPiece(new Bishop(new Position(3, 3)));
		board.addPiece(new Knight(new Position(6, 6)));
		board.addPiece(new Knight(new Position(5, 2)));
		System.out.println(board);
		System.out.println(board.threats(0, 1));	
		System.out.println(board.whoThreatsWho());
		

	}

}
