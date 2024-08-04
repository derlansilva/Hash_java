package com.hash;

import java.util.Scanner;

import com.hash.classes.Player;
import com.hash.controllers.HashController;

public class HashMain {
    private static HashController hashContrller = new HashController();
    private static Scanner scanner = new Scanner(System.in);
    private static String[] player = new String[2];
    private static String mensage = " VOCE COMEÇA";
    private static boolean check = false;

    private static String player1;
    private static String player2;

    public static void main(String[] args) {
        begin();
    }

    private static void begin() {
        
        System.out.print("JOGADOR 1:");
        player1 = scanner.nextLine();
        Player play1 = new Player(player1);
        play1.setSinal("X");
        hashContrller.putPlayer(play1);

        System.out.print("JOGADOR 2:");
        player2 = scanner.nextLine();
        Player play2 = new Player(player2);
        play2.setSinal("O");
        hashContrller.putPlayer(play2);

        chooisePlayer();

    }

    private static void chooisePlayer() {

        String p = hashContrller.choosePlayer().getName();

        if (p == player1) {

            player[0] = player1;
            player[1] = player2;

        } else {

            player[0] = player2;
            player[1] = player1;

        }

        start();
    }

    private static void start() {
        int round = 0;

        System.out.println("_______VAMOS COMERÇAR A PARTIDA_______");

        while (!check) {
            if (round == 9) {
                System.out.println("________________________________\n");

                System.out.println("FIM DE JOGO NINGUEM VENCEU");

                confirm();

            }
            String namePlayer;
            if (round % 2 != 0) {
                System.out.println("________________________________");
                System.out.println(player[0] + mensage);
                namePlayer = player[0];
                mensage = " SUA VEZ";
            } else {
                System.out.println("________________________________");
                System.out.println(player[1] + mensage);
                namePlayer = player[1];
                mensage = " SUA VEZ";
            }

            hashContrller.priHash();

            System.out.print("ESCOLHA UMA POSIÇÃO  ");
            int position = scanner.nextInt();

         
            if (position > 9 || position == 0) {

                System.out.println("________________________________");
                System.out.println("SOMENTE VALORES ENTRE 1 E 9");
                mensage = " ESCOLHA OUTRO VALOR ENTRE 1 E 9";

            } else {

                boolean confir = hashContrller.isMarked(position);

                if (confir == false) {

                    hashContrller.check(position, namePlayer);
                    round++;

                } else {
                    System.out.println("POSIÇÃO JA ESCOLHIDA\n");
                    mensage = " ESCOLHA OUTRA POSIÇÃO";
                }
                
                if (round > 4) {
                    boolean champiom = hashContrller.checkWinner();
                    if (champiom == true) {
                        System.out.println("\n");
                        hashContrller.priHash();
                        confirm();

                    }
                }
            }
        }
    }

    private static void confirm() {

        System.out.println("\n");
        System.out.println("________________________________");
        System.out.println("DESEJA RECOMEÇAR A PARTIDA?");
        System.out.println("[ 1 ] = SIM");
        System.out.println("[ 0 ] = NÃO");
        System.out.println("[ 2 ] = VISUALIZAR PLACAR");
        int chooise = scanner.nextInt();

        switch (chooise) {
            case 0:
                check = true;
                break;

            case 1:
                hashContrller.deleteAll();
                mensage = " VOCÊ COMEÇA ESSA PARTIDA";
                chooisePlayer();
                start();

                break;

            case 2:
                System.out.println("________________________________");
                hashContrller.scoreboard();
                hashContrller.deleteAll();
                mensage = " VOCÊ COMEÇA ESSA PARTIDA";
                confirm();
                break;

            default:
                System.out.println("ESCOLHA SOMENTE OS 3 NUMEROS MOSTRADOS");
                break;
        }

    }

}
