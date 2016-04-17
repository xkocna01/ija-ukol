/*
 * IJA 2015/2016
 * Ukol 1
 */
package ija.ija2015.homework2.board;


/**
 *
 * @author xkocna01
 */
public interface Field {
    
  public static enum Direction {
   LU(1), U(2), RU(3),
   L(4),        R(5), 
   LD(6), D(7), RD(8);
   //LU, U, RU,
   //L,     R, 
   //LD, D, RD;
   private int value;
   
   private Direction(int value) {
       this.value = value;
   }
 
  }
  
  public int myRow = 0;
  public int myCol = 0;
  Disk myDisk = null;
  
 /* static Field.Direction valueOf(java.lang.String name) {
     return null;
   }
   static Field.Direction[] values() {
     return null;
   }*/
  
  public void addNextField(Field.Direction dirs, Field field);  
  public Disk getDisk(); 
  public Field nextField(Field.Direction dirs);  
  public boolean putDisk(ija.ija2015.homework2.board.Disk disk);
  boolean canPutDisk(ija.ija2015.homework2.board.Disk disk);
  boolean isEmpty();
  
  public int getRow();
  public int getCol();
  public boolean process( ija.ija2015.homework2.board.Disk disk, Field.Direction dirs, int foundOponents, boolean putting );
    
}
