package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;

public class Main {
    static void main() {
        //1. Crear un arreglo e inicializarlo
        int A[]={4,2,6,8,9,3};
        int sumaArreglo=sumarArreglo(A);

        JOptionPane.showMessageDialog(null, sumaArreglo);
        boolean b=comprobarExistenciadeNumero(A);
        if (b==true){
            JOptionPane.showMessageDialog(null, "El número si está en el arreglo");
        }else{
            JOptionPane.showMessageDialog(null, "El número no está en el arreglo");
        }



    }
    public static int sumarArreglo(int A[]){
        //Metodo para sumar el arreglo
        int suma=0;
        int i;
        for (i=0; i< A.length;i++){
            suma+=A[i];
        }
        return suma;
    }
    public static boolean comprobarExistenciadeNumero(int A[]){
        boolean existencia =false;
        int numeroAComprobar=Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el número que quiere comprobar")
        );
        for (int i=0;i<A.length;i++){
            if (numeroAComprobar == A[i]){


                existencia=true;
                break;
            }
        }
        return existencia;

    }

    public static boolean verificarRepetido(int []A){
        boolean repetido=false;
        int contador=0;
        int num1=0;
        int num2=0;

        for (int i=0; i<A.length;i++){
            num1=A[i];
            for (int j=i+1;j<A.length;j++){
                num2=A[j];
                if (num1==num2){
                    return true;
                }
            }
            if (repetido){
                break;
            }
        }

        return repetido;
    }

}