/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.board;

/**
 *
 * @author David
 */
public interface Rules {
    
    public int mySize = 0;
    public int disks = 0;
    
    public Field createField(int row, int col);
        //Vytvoří odpovídající pole na zadaných indexech.
    
    public int getSize();
        //Vrací velikost desky.
    
    public int numberDisks();
        //Vrací počet kamenů jednotlivých hráčů.

}
