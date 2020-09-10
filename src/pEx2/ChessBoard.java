 package pEx2;

public class ChessBoard {
	ChessPiece [] pieces ;
	public ChessBoard () {
		pieces=new ChessPiece[10];
	}

	public String toString() {
		String toString="";
		for (int i = 0; i < pieces.length && pieces[i]!=null; i++) {
			toString+=pieces[i].toString()+"\n" ;
		}

		return toString;
	}
	// to add piece to an array with 10 places, only if there is an empty spot
	public void addPiece(ChessPiece p) {
		int i=0;
		while (pieces[i]!=null && i<10) {
			i++;
		}
		if (pieces[i]==null) {
			pieces[i]=p;
		}
	}

	//to check if p1 threats on p2
	public boolean threats(int p1, int p2) {
		int x2=0,y2=0;
		boolean flag=false;
		Bishop bx1;
		Knight k1;
		if (pieces[p1]==null ||pieces[p2]==null || p1>10 || p1<0|| p2>10 || p2<0) {
			return false;
		}
		if (pieces[p1] instanceof Bishop) {
			bx1=(Bishop) pieces[p1];	
			Position [] temp=bx1.moves(bx1.position);
			if (pieces[p2] instanceof Bishop) {
				bx1=(Bishop) pieces[p2];	
				x2=	bx1.position.getRow();
				y2=bx1.position.getCol();
			}
			else {
				k1=(Knight)pieces[p2];
				x2=	k1.position.getRow();
				y2=k1.position.getCol();
			}			for (int i = 0; i < temp.length; i++) {
				if (temp[i].getRow()==x2 && temp[i].getCol()==y2) {
					flag=true;
				}
			}
		}

		if (pieces[p1] instanceof Knight) {
			k1=(Knight)pieces[p1];
			Position p=new Position(k1.position.getRow(), k1.position.getCol());
			Position [] temp=k1.moves(p);
			if (pieces[p2] instanceof Bishop) {
				bx1=(Bishop) pieces[p2];	
				x2=	bx1.position.getRow();
				y2=bx1.position.getCol();
			}
			else {
				k1=(Knight)pieces[p2];
				x2=	k1.position.getRow();
				y2=k1.position.getCol();
			}	
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].getRow()==x2 && temp[i].getCol()==y2) {
					flag=true;
				}
			}
		}
		return flag;
	}
	//check all threats even if its the kind
	public String whoThreatsWho() {
		String allThreats="";
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 1; j < pieces.length; j++) {
				if (threats(i, j)) {
					if (pieces[i] instanceof Bishop) {
						Bishop bx1=(Bishop) pieces[i];	
						if (pieces[j]instanceof Knight) {
							Knight k1=(Knight)pieces[j];
							allThreats+= "Bishop at: ("+bx1.position.getRow()+","+ bx1.position.getCol()+") threats on  Knight at: ("
									+k1.position.getRow() +","+ k1.position.getCol()+") \n";
						}else {
							Bishop bx2=(Bishop) pieces[j];	
							allThreats+= "Bishop at: ("+bx1.position.getRow()+","+ bx1.position.getCol()+") threats on  Bishop at: ("
									+bx2.position.getRow() +","+ bx2.position.getCol()+") \n";
						}
					}else {
						Knight k1=(Knight)pieces[i];
						if (pieces[j]instanceof Knight) {
							Knight k2=(Knight)pieces[j];
							allThreats+= "Knight at: ("+k1.position.getRow()+","+ k1.position.getCol()+") threats on  Knight at: ("
									+k2.position.getRow() +","+ k2.position.getCol()+") \n";
						}else {
							Bishop bx2=(Bishop) pieces[j];	
							allThreats+= "Knight at: ("+k1.position.getRow()+","+ k1.position.getCol()+") threats on  Bishop at: ("
									+bx2.position.getRow() +","+ bx2.position.getCol()+") \n";	
						}
					}
				}
			}
		}
		return allThreats;
	}

}
