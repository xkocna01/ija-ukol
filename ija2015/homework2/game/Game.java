/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.Rules;

/**
 *
 * @author David
 */
public class Game {
    
    private Board board;
    private Rules rules;
    private Player playerW=null, playerB=null;
    private boolean curPlayer_W;
    
    public Game(Board board){
        this.board = board;
        this.rules = board.getRules();
    }
    
    public boolean addPlayer(Player player){
        if(this.playerW == null) {
            this.playerW = player;
            curPlayer_W = true;
            this.playerW.init(board);
            return true;
        }
        else if(this.playerB == null) {
            this.playerB = player;
            //curPlayer_W = false;
            this.playerB.init(board);
            return true;
        }
        else return false;
        
    }
    //Přidá hráče a současně vyvolá jeho inicializaci.
    
    public Player currentPlayer(){
        if(curPlayer_W) return playerW;
        else return playerB;
    }
    //Vrátí aktuálního hráče, který je na tahu.
    
    public Board getBoard(){
        return board;
    }
    //Vrátí hrací desku.
    
    public Player nextPlayer(){
        curPlayer_W = !curPlayer_W;
        if(curPlayer_W) return playerB;
        else return playerW;
    }
    
}
