package com.hash.classes;

public class Player {
    private String name ;
    private String sinal ;

    public Player(String name ){
        this.name = name;
    }


    public String getSinal() {
        return sinal;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  name;
    }
}
