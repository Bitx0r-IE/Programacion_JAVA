package com.company;

import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int option = 0;
    private static double sumTotal = 0;
    private static ArrayList<Double> lista;

    public static void main(String[] args) {
        /*Crea un arraylist parar guardar valores de tipo real (Float o Double) que iremos introduciendo por teclado hasta
        finalizar (mientras quiera continuar). Posteriormente muestra un menú para que el ususario pueda realizar una
        serie de opciones.*/
        try {
            //rellenar el arrayList:
            lista =  new ArrayList<Double>();
            initArrayList();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void initArrayList(){
        boolean continuar = false;
        do {
            try {
                double num = Double.parseDouble(JOptionPane.showInputDialog(null, "Teclea un número: "));
                lista.add((num));
                String pregunta = JOptionPane.showInputDialog(null, "¿Quiere continuar?(s/n): ");
                if (pregunta.equals("n")){
                    //Si no se quiere continuar añadiendo datos redirigir al menú de opciones:
                    menuSelec();
                }
                else {
                    continuar = false;
                }
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
        while (continuar);
    }
    public static void menuSelec (){
        //Crear menú de selección:
        boolean salir = false;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Menú de opciones: \n" +
                        "1.- Visualizar el valor máximo y el mínimo.\n" +
                        "2.- Solicitar un número y buscarlo. Muestra un mensaje indicando si lo has encontrado o no.\n" +
                        "3.- Solicitar un número, buscarlo y borrarlo. Sino se encuentra muestra un mensaje de error.\n" +
                        "4.- Convertir el arrayList en un array.\n" +
                        "5.- Si no está vacío, mostrar el número de elementos que contiene.\n" +
                        "6.- Insertar un nuevo elemento por el final.\n" +
                        "7.- Insertar un nuevo elemento en la posición que te indique el usuario.\n" +
                        "8.- Borrar un elemento de una posición concreta.\n" +
                        "9.- Calcular la suma y la media aritmética de los valores contenidos.\n" +
                        "10.- Finalizar.\n\n" +
                        "Escoge una de las opciones mostradas: "));
                if (option < 0 || option > 10){
                    throw new DatoNoValidoException();
                }
                eleccion();
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "ERROR: Escribe un número");
            }
            catch (DatoNoValidoException e){
                JOptionPane.showMessageDialog(null, "ERROR: Número no válido");
            }
        }
        while (salir);
    }
    public static void eleccion (){
        boolean salir = false;
        do {
            try {
                switch (option){
                    case 1:
                        MaxMin();
                        break;
                    case 2:
                        buscador();
                        break;
                    case 3:
                        buscadorBorrador();
                        break;
                    case 4:
                        covertArray();
                        break;
                    case 5:
                        numElementos();
                        break;
                    case 6:
                        insertNum();
                        break;
                    case 7:
                        insertNumPos();
                        break;
                    case 8:
                        delNum();
                        break;
                    case 9:
                        calcSumMedia();
                        break;
                    case 10:
                        salir = true;
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
        while (salir);
    }
    public static void MaxMin (){
        try{
            // Utilizando Collection en vez de una serie de bucles:
            Double max = Collections.max(lista);
            Double min = Collections.min(lista);
            // Print message:
            JOptionPane.showMessageDialog(null, "El máximo es: " + max + "\n" +
                    "El mínimo es: " + min);
            //Regresar al menú:
            menuSelec();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getClass());
        }
    }
    public static void buscador(){
        boolean salir = false;
        try{
            do {
                int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Número a encontrar: "));
                if (lista.contains(buscar)){
                    JOptionPane.showMessageDialog(null, "El elemento SI existe, en la posición " + lista.lastIndexOf(buscar));
                }
                else{
                    JOptionPane.showMessageDialog(null, "El elemento NO existe");
                }
            }
            while (salir);
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }
    public static void buscadorBorrador(){
        boolean salir = false;
        try{
            do {
                int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Número a encontrar: "));
                if (lista.contains(buscar)){
                    lista.remove(buscar);
                    JOptionPane.showMessageDialog(null, "El elemento ha sido borrado." );
                }
                else{
                    JOptionPane.showMessageDialog(null, "El elemento NO existe");
                }
            }
            while (salir);
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }
    public static void covertArray(){
        //Convertir en array:
        Double [] array;
        array = lista.toArray(new Double[lista.size()]);

        //Mostrar en pantalla los datos del array (opcional):
        String datos = "";
        for(int x = 0; x < array.length; x++){
            datos += array[x];
        }
        JOptionPane.showMessageDialog(null, array);
        menuSelec();
    }
    public static void numElementos(){
        boolean salir = false;
        do {
            try{
                if (lista.isEmpty()){
                    throw new ListaVaciaException();
                }
                else{
                    JOptionPane.showMessageDialog(null,"El tamaño del arrayList es: " + lista.size());
                    menuSelec();
                }
            }
            catch (ListaVaciaException e){
                JOptionPane.showMessageDialog(null, "ERROR: el arrayList está vacío");
            }
        }
        while (salir);
    }
    public static void insertNum(){

    }
    public static void insertNumPos(){

    }
    public static void delNum(){
        boolean salir = false;
        do {
            try{
                int pos = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Teclee la posción del número a borrar:"));
                lista.remove(pos);
                menuSelec();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
        while (salir);
    }
    public static void calcSumMedia(){

    }
}
