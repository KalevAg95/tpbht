/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbht;

import java.util.Scanner;

/**
 *
 * @author kalev
 */
public class Tpbht {
    public static Scanner in = new Scanner(System.in);  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Introduce tu numero de empleado:");
    String numEmpleado = in.nextLine();
    
    System.out.println("Introduce tu año de ingreso a la empresa (por ejemplo: 2018):");
    String fechaIngreso = in.nextLine();
    
    System.out.println("Introduce tu sueldo actual:");
    String sueldoActual = in.nextLine();
    
    System.out.println("Introduce tu area/departamento:\nA) Finanzas\nB) Ventas\nC)Atencion a clientes\nD)Otro");
    
    String area = in.nextLine();
    boolean esValido=false;
    do{
      if(area.equalsIgnoreCase("a")||area.equalsIgnoreCase("b")||area.equalsIgnoreCase("c")||area.equalsIgnoreCase("d")){
        esValido=true;
      }else{
        System.out.println("Valor introducido no valido\nIntroduce tu area/departamento:\nA) Finanzas\nB) Ventas\nC)Atencion a clientes\nD)Otro");
        area = in.nextLine();
      }

    }while(!esValido);
    
    String bono = CalcularBono(fechaIngreso,sueldoActual, area);
    System.out.println(bono);
   // Imprimir(bono, numEmpleado, fechaIngreso,sueldoActual, area);

    }
    
    
  public static String CalcularBono(String fechaIngreso, String sueldo, String area){
    double multiplicador = 1.0;

    if(Integer.parseInt(fechaIngreso)>2017){
      int dif = 2019 - Integer.parseInt(fechaIngreso);
      dif*=0.5;
      multiplicador+=dif;
    }

    switch(area.toLowerCase()) {
      case "a":
        multiplicador+=0.5;
        break;
      case "b":
        multiplicador+=0.75;
        break;
      case "c":
        multiplicador+=1.00;
        break;
      case "d":
        multiplicador+=0.25;
        break;   
    }

    return Double.toString(multiplicador);

  }
}
