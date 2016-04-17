/*
 * IJA 2015/2016
 * Ukol 1
 */
package ija.ija2015.homework2.board;


/**
 *
 * @author xkocna01
 */
public class BorderField implements Field {
  
  //protected Field[] array;
  protected int myRow;
  protected int myCol;
  //protected Disk myDisk = null;
    
  public BorderField(int row, int col){
      myRow = row;
      myCol = col;
  }
  
  public void addNextField(Field.Direction dirs, Field field){
  }
  
  public Disk getDisk() {
      return null;
  }  

  public Field nextField(Field.Direction dirs) {
      return null;
  } 
  
  public boolean putDisk(Disk disk) {
      return false;
  }
  
  
  public int getRow(){     
      return myRow;
  }
  public int getCol(){     
      return myCol;
  }

    @Override
    public boolean canPutDisk(Disk disk) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean process(Disk disk, Direction dirs, int foundOponents, boolean putting) {
        return false;
    }

}
