package com.company;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String num =generadorRandomNum();
    }
    public static String generadorRandomNum(){
        String num;
        boolean correcto;
        do {
            Integer num1 = (int)(Math.random() * 1000);
            //comprobar que las 3 cifras que forman el num son diferentes entre si
            num = String.valueOf(num1); //cambio de Integer a String
        }
        while();
    }
    public static String data (){
       boolean correcto = true;
       String num = "";
       //num  de 3 cifras
        if (num.length() != 3){
            correcto = false;
        }
        else{
            //comprobación de que los datos introducidos son numeros
            for(int cont = 0; cont<num.length()){

            }
        }
    }
}
