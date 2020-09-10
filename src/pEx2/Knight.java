package pEx2;

public class Knight implements ChessPiece {
	
		Position position;
		
		//Contractor that add position to knight
	public Knight(Position p) {
		if (p.getRow()<=8 && p.getRow()>0 && p.getCol()<=8 && p.getCol()>0) {
			position=new Position(p.getRow(), p.getCol());

		}
		else {
			System.out.println("worng value, so it's 1,1, indsted");
			position=new Position(1,1);	
		}
		}
	//pring the location of a knight
	public String toString() {
		return "Knight at "+ position.toString();
	}
	
	//check how many places knight could go, and returning an array accordingly
	public  Position[] moves(Position p) {
		int x = p.getRow(), y = p.getCol(),count=0;
		if((x-1>0)&&(y-2>0))
			count++;
		if((x+1<9)&&(y-2>0))
			count++;
		if((x+2<9)&&(y-1>0))
			count++;
		if((x+2<9)&&(y+1<9))
			count++;	
		if((x+1<9)&&(y+2<9))
			count++;	
		if((x-1>0)&&(y+2<9))
			count++;	
		if((x-2>0)&&(y+1<9))
			count++;
		if((x-2>0)&&(y-1>0))
			count++;
		Position[] positions = new Position[count];
		count=0;
		if((x-1>0)&&(y-2>0)) {
			positions[count]=new Position(x-1,y-2);
			count++;
		}
		if((x+1<9)&&(y-2>0)) {
			positions[count]=new Position(x+1,y-2);
			count++;
		}
		if((x+2<9)&&(y-1>0)) {
			positions[count]=new Position(x+2,y-1);
			count++;
		}
		if((x+2<9)&&(y+1<9)) {
			positions[count]=new Position(x+2,y+1);
			count++;
		}
		if((x+1<9)&&(y+2<9)) {
			positions[count]=new Position(x+1,y+2);
			count++;
		}
		if((x-1>0)&&(y+2<9)) {
			positions[count]=new Position(x-1,y+2);
			count++;
		}
		if((x-2>0)&&(y+1<9)) {
			positions[count]=new Position(x-2,y+1);
			count++;
		}
		if((x-2>0)&&(y-1>0)) {
			positions[count]=new Position(x-2,y-1);
		}
		return positions;
	}
	}
