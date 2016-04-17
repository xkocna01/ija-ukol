/*
 * IJA 2015/2016
 * Ukol 1
 */
package ija.ija2015.homework2.board;


/**
 *
 * @author xkocna01
 */
public class Board {
  
  protected int mySize = 0;
  protected Field[][] myBoard;
  protected Rules myRules;
  
  public Board(Rules rules){
    myRules = rules;
    mySize = myRules.getSize();
      //System.out.println("mySize: "+mySize);
    
    myBoard = new Field[mySize+2][mySize+2];
    
    for(int i=0; i<=mySize+1; i++){
        for(int j=0; j<=mySize+1; j++){
            if( i==0 || j==0 || i==mySize+1 || j==mySize+1 )
                myBoard[i][j] = new BorderField(i,j);
            else
                myBoard[i][j] = myRules.createField(i, j);
        }
    }
    
    //myBoard[0][0].addNextField(Field.Direction.R, getField(0,1) );
    //myBoard[1][1].addNextField(Field.Direction.U, getField(0,1) );
    
    for(int i=0; i<=mySize+1; i++){
        for(int j=0; j<=mySize+1; j++){  
            //System.out.println("i:"+i+" j:"+j);
            myBoard[i][j].addNextField(Field.Direction.LU, getField(i-1,j-1) );
            myBoard[i][j].addNextField(Field.Direction.U, getField(i-1,j) ); 
            myBoard[i][j].addNextField(Field.Direction.RU, getField(i-1,j+1) );
            myBoard[i][j].addNextField(Field.Direction.L, getField(i,j-1) );
            myBoard[i][j].addNextField(Field.Direction.R, getField(i,j+1) );
            myBoard[i][j].addNextField(Field.Direction.LD, getField(i+1,j-1) );
            myBoard[i][j].addNextField(Field.Direction.D, getField(i+1,j) );
            myBoard[i][j].addNextField(Field.Direction.RD, getField(i+1,j+1) );
        }
    }
    
  }
  
  public int getSize(){
    return mySize; 
  }
  
  public Field getField(int row, int col){
    if( row<=mySize+1 && col<=mySize+1 && row>=0 && col>=0 ){
        //System.out.println("getField() v rozsahu "+row+" "+col);
        return myBoard[row][col];
    }
    else
        return null;
  }
  
  public Rules getRules(){
      return myRules;
  }
    
}
