/*
 * IJA 2015/2016
 * Ukol 1
 */
package ija.ija2015.homework2.board;

import java.util.Arrays;
import java.util.Objects;


/**
 *
 * @author xkocna01
 */
public class BoardField implements Field {
  
  protected Field[] array;
  protected int myRow;
  protected int myCol;
  protected Disk myDisk;
    
  public BoardField(int row, int col){
      myRow = row;
      myCol = col;
      myDisk = null;
      array = new Field[8];
  }
  
  
  public void addNextField(Field.Direction dirs, Field field){
      //System.out.println("BoardField.addNexttField() : dirs.ordinal()="+dirs.ordinal());
      //System.out.println("BoardField addNextField() myRow:Col="+myRow+":"+myCol+" newField="+field.getRow()+":"+field.getCol());
      if(field != null)
          array[dirs.ordinal()] = field;  
          
  }
  
  
  public Disk getDisk() {
      return myDisk;
  }  

  
  public Field nextField(Field.Direction dirs) {
      //System.out.println("nextField "+dirs+" "+dirs.ordinal()+" row/col:"+myRow+"/"+myCol+" okolni:"+array[dirs.ordinal()].getRow()+"/"+array[dirs.ordinal()].getCol()+" obj:"+array[dirs.ordinal()]);
      
      return ( array[dirs.ordinal()] );
  } 
  
  
  public boolean putDisk(Disk disk) {
      if( myDisk == null ){
        myDisk = disk;
        return true;
      }
      else
        return false;
  }
  
  
   public int getRow(){     
      return myRow;
  }
   public int getCol(){     
      return myCol;
  }

    @Override
    public int hashCode() {
        int hash = 4;
        hash = 47 * hash + this.myRow;
        hash = 47 * hash + this.myCol;
        hash = 47 * hash + Objects.hashCode(this.myDisk);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoardField other = (BoardField) obj;
        if (this.myRow != other.myRow) {
            return false;
        }
        if (this.myCol != other.myCol) {
            return false;
        }
        if (!Objects.equals(this.myDisk, other.myDisk)) {
            return false;
        }
        return true;
    } 

    @Override
    public boolean canPutDisk(ija.ija2015.homework2.board.Disk disk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean process(Disk disk, Direction dirs, int foundOponents, boolean putting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
