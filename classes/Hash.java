package com.hash.classes;


public class Hash {

    private boolean isChecked = false;
    private String sinal ;
    int count = 1;

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public String getSinal() {
        return sinal;
    }
    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    @Override
    public String toString() {
        
        return (isChecked ? "[ "+ this.sinal +" ]" : "[   ]");
       
    }

}
