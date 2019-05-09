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
    
    Double bono = CalcularBono(fechaIngreso,sueldoActual,area);
    bono = bono*Double.parseDouble(sueldoActual);
    
    String bonoStr=Double.toString(bono);
    Imprimir(bonoStr, numEmpleado, fechaIngreso,sueldoActual, area);

    }
    
    
  public static Double CalcularBono(String fechaIngreso, String sueldo, String area){
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
    return multiplicador;

  }
  
   public static void Imprimir(String bono, String numEmpleado,String fechaIngreso, String sueldo, String area){
       String nombreArea="";
       switch(area.toLowerCase()) {
      case "a":
        nombreArea="Finanzas";
        break;
      case "b":
        nombreArea="Ventas";
        break;
      case "c":
        nombreArea="Atencion a clientes";
        break;
      case "d":
        nombreArea="Otros";
        break;   
    }
       System.out.println("--------------------------------------------\n"
               + "Numero de empleado: "+numEmpleado+"\nAño de ingreso: " + fechaIngreso+"\nSueldo Actual: $"+sueldo+"\nArea: "+nombreArea+"\nUsted cuenta con un bono de: $"+bono);
       
  
   }
}
