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
         
                if(hashs.get(1).getSinal() == hashs.get(2).getSinal() && 
                hashs.get(1).getSinal() == hashs.get(3).getSinal() 
                && hashs.get(2).getSinal() == hashs.get(3).getSinal()){
            
                    boolean result = getchampion(1);
                    return result;
                    
                }

                // SE A SEGUNDA LINHA ESTIVER PREENCHIDA DO 4 AO 6
                if(hashs.get(4).getSinal() == hashs.get(5).getSinal() && 
                hashs.get(4).getSinal() == hashs.get(6).getSinal() 
                && hashs.get(5).getSinal() == hashs.get(6).getSinal()){

                    boolean result = getchampion(4);
                    return result;

                }

                // SE A SEGUNDA LINHA ESTIVER PREENCHIDA DO 7 AO 9
                if(hashs.get(7).getSinal() == hashs.get(8).getSinal() && 
                hashs.get(7).getSinal() == hashs.get(9).getSinal() 
                && hashs.get(8).getSinal() == hashs.get(9).getSinal()){

                    boolean result = getchampion(7);
                    return result;

                }
                

                // VERIFICAR VENCEDORES DAS LINHAS LATERAIS
                // VENCEDOR DAS LINHAS 1 , 4 , 7
                if(hashs.get(1).getSinal() == hashs.get(4).getSinal() && 
                hashs.get(1).getSinal() == hashs.get(7).getSinal() 
                && hashs.get(4).getSinal() == hashs.get(7).getSinal()){

                    boolean result = getchampion(1);
                    return result;

                }

                //VENCEDOR DAS LINHAS 2 , 5 , 8
                if(hashs.get(2).getSinal() == hashs.get(5).getSinal() && 
                hashs.get(2).getSinal() == hashs.get(8).getSinal() 
                && hashs.get(5).getSinal() == hashs.get(8).getSinal()){

                    boolean result = getchampion(2);
                    return result;

                }
                //VENCEDOR DAS LINHAS 3 , 6 , 9

                if(hashs.get(3).getSinal() == hashs.get(6).getSinal() && 
                hashs.get(3).getSinal() == hashs.get(9).getSinal() 
                && hashs.get(6).getSinal() == hashs.get(9).getSinal()){

                    boolean result = getchampion(3);
                    return result;

                }


                // AGORA LOGICA PARA VERIFICAR VENCEDORES NAS DIAGONAIS


                //VENCEDOR NAS LINHAS 1 , 5 , 9
                if(hashs.get(1).getSinal() == hashs.get(5).getSinal() && 
                hashs.get(1).getSinal() == hashs.get(9).getSinal() 
                && hashs.get(5).getSinal() == hashs.get(9).getSinal()){

                    boolean result = getchampion(1);
                    return result;

                }
                //VENCEDOR DAS LINHAS 3, 5 , 7

                if(hashs.get(3).getSinal() == hashs.get(5).getSinal() && 
                hashs.get(3).getSinal() == hashs.get(7).getSinal() 
                && hashs.get(5).getSinal() == hashs.get(7).getSinal()){

                    boolean result = getchampion(3);
                    return result;
                    
                }
        return false;
    }

    public boolean getchampion(int index){

        String signal = hashs.get(index).getSinal();

        Player play = findPlayer(signal);
        System.out.println(play);
        play.setVictorys(+1);
        System.out.println("________________________________");
        System.out.println(play.getName()+ " VOCE GANHOU ");
       
        return true;
    }

    public void deleteAll(){
        for (Hash hash : hashs) {
            hash.setSinal(null);
            hash.setChecked(false);
        }
    }

    public Player findPlayer(String signal){
        for (Player player : players) {
            if(signal == player.getSinal()){
                return player;
            }
        }
        return null;
    }
}
