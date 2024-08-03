package com.hash;

import java.util.Random;
import java.util.Scanner;

import com.hash.classes.Hash;
import com.hash.classes.Player;
import com.hash.controllers.HashController;

public class HashMain {
    private static HashController hashContrller = new HashController();
    private static Scanner scanner = new Scanner(System.in);
    private static String[] player = new String[2];
    private static String mensage = " VOCE COMEÇA";

    public static void main(String[] args) {

        begin();
       
    }

    private static void begin(){
        System.out.print("JOGADOR 1:");
        String name = scanner.nextLine();
        Player play1 = new Player(name);
        play1.setSinal("X");
        hashContrller.putPlayer(play1);

        System.out.print("JOGADOR 2:");
        String player2 = scanner.nextLine();
        Player play2 = new Player(player2);
        play2.setSinal("O");
        hashContrller.putPlayer(play2);

        String p = hashContrller.choosePlayer().getName();

        if (p == name) {
            player[0] = name;
            player[1] = player2;
        } else {
            player[0] = player2;
            player[1] = name;
        }

        start();

    }

    private static void start() {
        int round = 0;

        System.out.println("VAMOS COMERÇAR A PARTIDA");
        boolean check = false;

        while (!check) {
            if (round == 9) {
                System.out.println("_________________________________");
                
                System.out.println("FIM DE JOGO NINGUEM VENCEU\n");
                hashContrller.priHash();
                System.out.println("\n");
                System.out.println("DESEJA RECOMEÇAR A PARTIDA?");
                System.out.println("[ 1 ] = SIM");
                System.out.println("[ 0 ] = NÃO");
                int chooise = scanner.nextInt();

                if(chooise == 1){
                    hashContrller.deleteAll();
                    start();
                }
                check = true;
                
            }
            String namePlayer;
            if (round % 2 != 0) {
                System.out.println("________________________________");
                System.out.println(player[0] + mensage );
                namePlayer = player[0];
                mensage = " SUA VEZ";
            } else {
                System.out.println(player[1] +mensage);
                namePlayer = player[1];
                mensage = " SUA VEZ";
            }
            hashContrller.priHash();
            System.out.print("ESCOLHA UMA POSIÇÃO  ");
            int position = scanner.nextInt();

            boolean confir = hashContrller.isMarked(position);
            if(confir == false){
                hashContrller.check(position, namePlayer);
                round++;
            }else{
                System.out.println("POSIÇÃO JA ESCOLHIDA\n");
                mensage = " ESCOLHA OUTRA POSIÇÃO";
            }

            hashContrller.checkWinner();
        }
    }

}
