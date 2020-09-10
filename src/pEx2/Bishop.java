package pEx2;

public class Bishop implements ChessPiece {
	public	Position position;
	
	//Contractor that add position to bishop
	public Bishop(Position p) {
		if (p.getRow()<=8 && p.getRow()>0 && p.getCol()<=8 && p.getCol()>0) {
			position=new Position(p.getRow(), p.getCol());

		}
		else {
			System.out.println("worng value, so it's 1,1, indsted");
			position=new Position(1,1);
		}
	}
	
//check how many places bishop could go, and returning an array accordingly
		public  Position[] moves(Position p) {
			int x =p.getRow(), y =  p.getCol(),count=0,index=0;
			
			switch (p.getRow()) {
			case 1:
				count=7;	
				break;
			case 2:
				if (y==1 || y ==8) {
					count=7;	
				}else
					count=9;	
				break;
			case 3:
				if (y==1 || y ==8) {
					count=7;	
				}else if (y==2||y ==7) {
					count=9;	
				}else 
					count=11;	
				break;
			case 4:
				if (y==1 || y ==8) {
					count=7;	
				}else if (y==2||y ==7) {
					count=9;	
				}else if (y==3 ||y==6) {
					count=11;	
				}else 
					count=13;	
				break;
			case 5:
				if (y==1 || y ==8) {
					count=7;	
				}else if (y==2||y ==7) {
					count=9;	
				}else if (y==3 ||y==6) {
					count=11;	
				}else 
					count=13;	
				break;
			case 6:
				if (y==1 || y ==8) {
					count=7;	
				}else if (y==2||y ==7) {
					count=9;	
				}else 
					count=11;	
				break;
			case 7:
				if (y==1 || y ==8) {
					count=7;	
				}else
					count=9;	
				break;
			case 8:
				count=7;	
				break;
			default:
				System.out.println("does not exists");
				break;
			}
			Position [] p1 = new Position[count];
			int i=1;
			while (i<count) {
				if (x+i>0 && y+i>0 && x+i<9 && y+i<9 ) {
					p1[index]=new Position(x+i, y+i);
					index++;
				}
				if (x-i>0 && y-i>0 && x-i<9 && y-i<9) {
					p1[index]=new Position(x-i, y-i);
					index++;
				}
				
				if (x-i>0 && y+i>0 && x-i<9 && y+i<9) {
					p1[index]=new Position(x-i, y+i);
					index++;
				}
				if (x+i>0 && y-i>0 && x+i<9 && y-i<9) {
					p1[index]=new Position(x+i, y-i);
					index++;
				}
				i++;
			}
			
						return p1;
		}
//print the location of bishop
	public String toString () {
		return "Bishop at" +position.toString();
	}
}

