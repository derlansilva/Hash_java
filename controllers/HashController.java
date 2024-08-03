package com.hash.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hash.classes.Hash;
import com.hash.classes.Player;

public class HashController {
    private List<Hash> hashs = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    Random random = new Random();

    public HashController(){
        putPositions();
        //checkWinner();
    }

    public Player choosePlayer(){
        int index = random.nextInt(players.size());
        return players.get(index);
        
    }
    public void putPlayer(Player player ){
        players.add(player);
    }
    public boolean isMarked(int index){
        if(hashs.get(index).getSinal() != null){
            return true;
        }
        return false;
    }

    public void putPositions(){
        for(int i = 0; i<=9; i++ ){
            Hash hash = new Hash();
            hashs.add(hash);
        }
    }

    public void priHash(){
        int index = 0;
        for(int i = 0 ; i< 3; i++){
            for(int x = 0 ; x < 3; x++){
                index ++ ;
                System.out.print(hashs.get(index));
                
            }
            System.out.println();
        }

    }

    public void check(int index , String name){
        for(int i = 0 ; i < players.size(); i++){
            if(players.get(i).getName() == name){
                hashs.get(index).setSinal(players.get(i).getSinal());
            }
        }
        hashs.get(index).setChecked(true);
    }


    public boolean checkWinner(){
            for(int x =0; x <3 ; x++){
                for (Hash hash : hashs) {
                    
                }
            }
           
            //return false;
            //System.out.println("checando " + hash.getSinal());
        
        return false;
    }

    public void deleteAll(){
        hashs.clear();
    }
}
