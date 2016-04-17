/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Disk;
import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.board.ReversiField;
import ija.ija2015.homework2.board.Rules;

/**
 *
 * @author David
 */
public class ReversiRules implements Rules {
    
    protected int mySize = 0;
    protected int numDisks = 32;
    
    public ReversiRules(int size){
        this.mySize = size;
    }
    
    //Vytvoří odpovídající pole na zadaných indexech.
    public Field createField(int row, int col){
        Field f = new ReversiField(row, col); 
        
        if( (row==4 && col==4) || (row==5 && col==5) )
            f.putDisk(new Disk(true));
        else if( (row==4 && col==5) || (row==5 && col==4) )
            f.putDisk(new Disk(false));
        
        return f;
    }

    //Vrací velikost desky.       
    public int getSize(){
        return mySize;
    }
    
    //Vrací počet kamenů jednotlivých hráčů.
    public int numberDisks(){
        return numDisks;
    }
   
    
}
