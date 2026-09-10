package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;
public class Main {
    static void main() {
        int Matrix[][]= {{1,2,3,4},
                         {5,6,7,8},
                         {9,10,11,12},
                        {13,14,15,16}};
        String matrixVisual=imprimirMatriz(Matrix);
        JOptionPane.showMessageDialog(null,matrixVisual);
        int suma=sumarMatriz(Matrix);
        JOptionPane.showMessageDialog(null,suma);
        int sumaDiagonal=sumarDiagonalDeMatriz(Matrix);
        JOptionPane.showMessageDialog(null,sumaDiagonal);

    }
    public static String imprimirMatriz(int Matrix[][]){
        String msg="[";
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j< Matrix.length;j++){
                int text=Matrix[i][j];
                msg+=text+" , ";
            }


            if(i<Matrix.length-1) {
                msg += "\n";
            }

        }
        msg+="]";
        return msg;
    }
    public static int sumarMatriz(int Matrix[][]){
        int suma=0;
        for(int i=0;i<Matrix.length;i++){
            for (int j=0;j< Matrix.length;j++){
                suma+=Matrix[i][j];
            }
        }
        return suma;
    }
    public static int sumarDiagonalDeMatriz(int Matrix[][]){
        int sumaDiagonal=0;
        for (int i=0;i<Matrix.length;i++){
            for (int j=0;j<Matrix.length;j++){
                if (i==j){
                    sumaDiagonal+=Matrix[i][j];
                }
            }
        }
        return sumaDiagonal;
    }
    public static void MatrizEspiral(){
        //Me doy 😔

    }
}
