package com.mycompany.reto1;
import java.util.Scanner;
class RETO1{
    private final Scanner scanner = new Scanner(System.in);
    public String read(){
    	System.out.println("El G28 son unos tesos!");
        return this.scanner.nextLine();
    }
    private void run(){
        //LEER DATOS DE INGRESO
        String[] entrada = read().split(" ");
        double masa = Double.parseDouble(entrada[0]);
        double altura = Double.parseDouble(entrada[1]);
        double edad = Double.parseDouble(entrada[2]);
        
        // OPERACIONES SOBRE ESOS DATOS DE ENTRADA
        double imc = masa / (altura*altura);
        
        //MUESTRA DE RESULTADOS
        if ((masa<0 || masa >150)||(altura< 0.1 || altura > 2.5)||(edad<0||edad>110)){
            System.out.println("ERROR");
        }
        else if((edad < 45)&&(imc < 22)){
            System.out.println(String.format("%.1f", imc)+ " BAJO ");
        }
        else if ((edad < 45)&&(imc >= 22)){
            System.out.println(String.format("%.1f" , imc)+ " MEDIO");
        }
        else if ((edad >= 45)&&(imc < 22)){
            System.out.println(String.format("%.1f" , imc)+ "MEDIO");
        }
        else if ((edad >= 45)&&(imc >= 22)){
            System.out.println(String.format("%.1f" , imc)+ "ALTO");
        }
    }
    public static void main(String[] args) {
        RETO1 main = new RETO1();
        main.run();
    }    
}
