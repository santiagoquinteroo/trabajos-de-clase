package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;
public class Main {
    static void main() {
        int Matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};


        String matrixVisual = imprimirMatriz(Matrix);
        JOptionPane.showMessageDialog(null, "La matriz es: " + "\n" + matrixVisual);
        int suma = sumarMatriz(Matrix);
        JOptionPane.showMessageDialog(null, "La suma de la matriz es: " + suma);
        int sumaDiagonal = sumarDiagonalDeMatriz(Matrix);
        JOptionPane.showMessageDialog(null, "La suma de la diagonal de la matriz es: " + sumaDiagonal);
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de columnas y filas que quiere que tenga su matriz (es una matriz cuadrada)"));
        int MatrizEspiral[][] = MatrizEspiral(n);
        String matrizEspiral = imprimirMatrizEspiral(MatrizEspiral);

        JOptionPane.showMessageDialog(null, matrizEspiral);


    }

    public static String imprimirMatriz(int Matrix[][]) {
        String msg = "[";
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                int text = Matrix[i][j];
                msg += text + " , ";
            }


            if (i < Matrix.length - 1) {
                msg += "\n";
            }

        }
        msg += "]";
        return msg;
    }

    public static int sumarMatriz(int Matrix[][]) {
        int suma = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                suma += Matrix[i][j];
            }
        }
        return suma;
    }

    public static int sumarDiagonalDeMatriz(int Matrix[][]) {
        int sumaDiagonal = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix.length; j++) {
                if (i == j) {
                    sumaDiagonal += Matrix[i][j];
                }
            }
        }
        return sumaDiagonal;
    }

    public static int[][] MatrizEspiral(int n) {

        int[][] matriz = new int[n][n];

        int numero = 1;

        int arriba = 0;
        int abajo = n - 1;
        int izquierda = 0;
        int derecha = n - 1;

        while (arriba <= abajo && izquierda <= derecha) {
            for (int columna = izquierda; columna <= derecha; columna++) {
                matriz[arriba][columna] = numero;
                numero++;
            }
            arriba++;

            for (int fila = arriba; fila <= abajo; fila++) {
                matriz[fila][derecha] = numero;
                numero++;
            }
            derecha--;

            for (int columna = derecha; columna >= izquierda; columna--) {
                matriz[abajo][columna] = numero;
                numero++;
            }
            abajo--;

            for (int fila = abajo; fila >= arriba; fila--) {
                matriz[fila][izquierda] = numero;
                numero++;
            }
            izquierda++;
        }

        return matriz;
    }

    public static String imprimirMatrizEspiral(int matrizEspiral[][]) {
        String msg = "";
        for (int i = 0; i < matrizEspiral.length; i++) {
            for (int j = 0; j < matrizEspiral.length; j++) {
                msg += matrizEspiral[i][j];
                msg += " , ";
            }
            if (i < matrizEspiral.length - 1) {
                msg += "\n";
            }

        }
        return msg;
    }

}


