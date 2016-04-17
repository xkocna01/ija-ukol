/*
 * IJA 2015/2016
 * Ukol 1
 */
package ija.ija2015.homework2.board;


/**
 *
 * @author xkocna01
 */
public class Disk {
  
  protected boolean iamWhite;
  
  public Disk(boolean isWhite) {
    iamWhite = isWhite;
  }
  
  public boolean isWhite() {
    return iamWhite;
  }
  
  public void turn() {
    if (iamWhite) iamWhite = false;
    else iamWhite = true;
  }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.iamWhite ? 1 : 0);
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
        final Disk other = (Disk) obj;
        if (this.iamWhite != other.iamWhite) {
            return false;
        }
        return true;
    }
  
  
    
}
