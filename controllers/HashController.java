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

    public HashController() {
        putPositions();
    }

    public Player choosePlayer() {
        int index = random.nextInt(players.size());
        return players.get(index);

    }

    public void putPlayer(Player player) {
        players.add(player);
    }

    public boolean isMarked(int index) {
        if (hashs.get(index).getSinal() != null) {
            return true;
        }
        return false;
    }

    public void putPositions() {
        for (int i = 0; i <= 9; i++) {
            Hash hash = new Hash();
            hashs.add(hash);
        }
    }

    public void priHash() {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                index++;
                System.out.print(hashs.get(index));

            }
            System.out.println();
        }

    }

    public void check(int index, String name) {

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName() == name) {
                hashs.get(index).setSinal(players.get(i).getSinal());
            }
        }
        hashs.get(index).setChecked(true);
    }

    public boolean checkWinner() {
        String signal1 = hashs.get(1).getSinal();
        String signal2 = hashs.get(2).getSinal();
        String signal3 = hashs.get(3).getSinal();

        String signal4 = hashs.get(4).getSinal();
        String signal5 = hashs.get(5).getSinal();
        String signal6 = hashs.get(6).getSinal();

        String signal7 = hashs.get(7).getSinal();
        String signal8 = hashs.get(8).getSinal();
        String signal9 = hashs.get(9).getSinal();

        //VERIFICAR DE 1 2 3 
        if(signal1 != null && signal1.equals(signal2) && signal2.equals(signal3)){
            boolean result = getchampion(1);
                return result;
        }
        //VERIFICA DE 4 5 6 
        if(signal4 != null && signal4.equals(signal5) && signal5.equals(signal6)){
            boolean result = getchampion(4);
                return result;
        }
        //VERIFICA 7 8 9 
        if(signal7 != null && signal7.equals(signal8) && signal8.equals(signal9)){
            boolean result = getchampion(7);
                return result;
        }
        //VERIFICA 1 4 7 
        if(signal1 != null && signal1.equals(signal4) && signal4.equals(signal7)){
            boolean result = getchampion(1);
                return result;
        }
        //VERIFICA 2 5 8
        if(signal2 != null && signal2.equals(signal5) && signal5.equals(signal8)){
            boolean result = getchampion(2);
                return result;
        }
        //VERIFICA 3 6 9
        if(signal3 != null && signal3.equals(signal6) && signal6.equals(signal9)){
            boolean result = getchampion(3);
                return result;
        }
        //VERIFICA 1 5 9
        if(signal1 != null && signal1.equals(signal5) && signal5.equals(signal9)){
            boolean result = getchampion(1);
                return result;
        }
        //VERIFICA 3 5 7 
        if(signal3 != null && signal3.equals(signal5) && signal5.equals(signal7)){
            boolean result = getchampion(3);
                return result;
        }
       
        return false;
    }

    public boolean getchampion(int index) {

        String signal = hashs.get(index).getSinal();

        Player play = findPlayer(signal);

        System.out.println("________________________________");

        System.out.println(play.getName() + " VOCE GANHOU ");

        return true;
    }

    public void deleteAll() {
        for (Hash hash : hashs) {
            hash.setSinal(null);
            hash.setChecked(false);
        }
    }

    public Player findPlayer(String signal) {
        for (Player player : players) {
            if (signal == player.getSinal()) {
                player.setVictorys(+1);
                return player;
            }
        }
        return null;
    }

    public void scoreboard() {
        System.out.println("PLACAR");
        System.out.println(players.get(0).getName() + "  - " + players.get(0).getVictorys());
        System.out.println(players.get(1).getName() + "  - " + players.get(1).getVictorys());
    }
}
