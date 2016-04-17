/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.Disk;
import ija.ija2015.homework2.board.Field;

import java.util.*;

/**
 *
 * @author David
 */
public class Player {
    
    protected boolean amWhite;
    protected int numDisks;
    protected Disk[] disks;
    protected Stack stack = new Stack();
    
    public Player(boolean isWhite){
        this.amWhite = isWhite;
    }
    
    //Test, zda je možné vložit nový kámen hráče na dané pole.
    public boolean canPutDisk(Field field){
        if(!emptyPool()){
            
            
            
            boolean can=false;
            if(field.myDisk!=null) return false;
        
            for(Field.Direction dir : Field.Direction.values()) {
                if( field.nextField(dir).process( (new Disk(amWhite)), dir, 0, false ) ) can = true; 
                System.out.println("  -> skoncil s "+can);

            }

            System.out.println("  => field.canPD() = "+can);
            System.out.println(" ------------------------------------");
            return can;
            
            
            
            //boolean temp = field.canPutDisk( (new Disk(amWhite)) );
            //System.out.println("Player.canPutDisk() return "+temp);
            //return temp;
        }
        return false;
    }
    
    //Test prázdnosti sady kamenů, které má hráč k dispozici.
    public boolean emptyPool(){
        return (numDisks < 1);
    }
    
    //Inicializace hráče v rámci hrací desky.
    public void init(Board board){
        numDisks = 32;
        for(int i=0; i<numDisks; i++)
            stack.push(new Disk(amWhite));
            //disks[i] = new Disk(amWhite);
    }
    
    //Test barvy hráče.
    public boolean isWhite(){
        return amWhite;
    }
   
    //Vloží nový kámen hráče na dané pole, pokud to pravidla umožňují.        
    public boolean putDisk(Field field){        
        //if( !canPutDisk(field) ) return false;
        
        
        boolean can=false;
            if(field.myDisk!=null) return false;
        
            for(Field.Direction dir : Field.Direction.values()) {
                if( field.nextField(dir).process( (new Disk(amWhite)), dir, 0, true ) ) can = true; 
            }
        
        
        if(!can) return false;
        
        numDisks--;
        field.putDisk( (Disk)stack.pop() );
        return true;
    }

    @Override
    public String toString() {
        if(amWhite)
            return "white";
        else
            return "black";
    }
    
    
    
}
