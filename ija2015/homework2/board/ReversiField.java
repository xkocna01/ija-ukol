/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.board;

import java.util.Objects;

/**
 *
 * @author David
 */
public class ReversiField implements Field {
    
  protected Field[] array;
  protected int myRow;
  protected int myCol;
  protected Disk myDisk=null;
    
    public ReversiField(int row, int col){
      myRow = row;
      myCol = col;
      myDisk = null;
      array = new Field[8];       
    }
    
  public void addNextField(Field.Direction dirs, Field field){
      if(field != null)
          array[dirs.ordinal()] = field;  
          
  }
  
  
  public Disk getDisk() {
      return myDisk;
  }  

  
  public Field nextField(Field.Direction dirs) {
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
        final ReversiField other = (ReversiField) obj;
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
    
    
    public boolean process( ija.ija2015.homework2.board.Disk disk, Field.Direction dirs, int foundOponents, boolean putting ){
        
        System.out.println("zkousim "+dirs.name()+" na "+this.getRow()+":"+this.getCol()+" dosud nalezeno:"+foundOponents); ///// TODO: dodělat otáčení přeskočených kamenů!!!!
        
        if(this.myDisk == null) return false;
            
        System.out.println("  nejaky disk tu je na "+this.getRow()+":"+this.getCol());
            
        if(this.myDisk.isWhite() != disk.isWhite()){
            foundOponents++;
            System.out.println("  nasel protivnikuv disk na "+this.getRow()+":"+this.getCol()+" uz:"+foundOponents+". disk");
                
            //if( !nextField( dirs ).process( disk, dirs, foundOponents ) ) return false;
            if ( nextField( dirs ).process( disk, dirs, foundOponents, putting ) ){
                if(putting) this.getDisk().turn();
                return true;
            }
                       
            return false;
        }  
        else if(foundOponents > 0){          
            return true;   
        }
        
        
        return false;      
    }
    

    @Override
    public boolean canPutDisk(Disk disk) {
        boolean can=false;
        
        if(this.myDisk!=null) return false;
        
        for(Field.Direction dir : Field.Direction.values()) {
            if( nextField(dir).process( disk, dir, 0, false ) ) can = true; 
            System.out.println("  -> skoncil s "+can);
            
        }
        
        System.out.println("  => field.canPD() = "+can);
        System.out.println(" ------------------------------------");
        return can;
        
    }

    @Override
    public boolean isEmpty() {
        return(myDisk==null);
    }
    
    
    
    
}
